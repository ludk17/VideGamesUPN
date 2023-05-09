using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

using UnityEngine.SceneManagement;


public class PlayerController : MonoBehaviour
{
    public AudioClip[] audios;
    public GameObject gameManager;
    public GameObject bala;

    
    private GameManagerController gmController;
    private List<string> skills;

    private Rigidbody2D rb;
    private AudioSource audioSource;
    private Transform balaTransform;
    

    private bool balaExiste = false;
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        audioSource = GetComponent<AudioSource>();
        gmController = GameObject.Find("GameManagerObject").GetComponent<GameManagerController>();
    }

    void Update()
    {

        //rb.velocity = new Vector2(0, rb.velocity.y);

        if(Input.GetKey(KeyCode.RightArrow)) {
          rb.velocity = new Vector2(10, rb.velocity.y);
        }

        if(Input.GetKeyDown(KeyCode.LeftArrow)) {
          MoverIzquierda();
        }

        if(Input.GetKeyUp(KeyCode.LeftArrow)) {
          Detenerse();
        }



        Saltar();
        Disparar();
        DividirDisparo();
    }

    public void MoverIzquierda() {
      rb.velocity = new Vector2(-10, rb.velocity.y);
    }
    public void Detenerse() {
      rb.velocity = new Vector2(0, rb.velocity.y);
    }

    private void Saltar() {
      if(Input.GetKeyUp(KeyCode.Space)) {
        ReproducirSonidoSalto();
      }
    }

    public void ReproducirSonidoSalto() {
      audioSource.PlayOneShot(audios[0]);
    }

    private void Disparar() {
      skills = gmController.GetSkills();

      if(Input.GetKeyUp(KeyCode.X) && skills.Contains("DISPARAR")) {
        balaExiste = true;
        var position = transform.position;
        var x = position.x + 1;
        var newPosition = new Vector3(x, position.y, position.z);
        
        GameObject balaGenerada = Instantiate(bala, newPosition, Quaternion.identity);
        balaTransform = balaGenerada.transform;
        GanarPuntos();
      }
    }

    private void DividirDisparo() {
      // solo se divide si la bala existe y presiono C
      //transform.position
      if(balaExiste && Input.GetKeyUp(KeyCode.Y)) {

        var position = balaTransform.position;
        var positionBala2 = new Vector3(position.x + 1, position.y + 1, position.z); 
        var positionBala3 = new Vector3(position.x + 1, position.y - 1, position.z); 

        GameObject balaGenerada2 = Instantiate(bala, positionBala2, Quaternion.identity);

        (balaGenerada2.GetComponent<BalaController>()).velocityY = 1;

        GameObject balaGenerada3 = Instantiate(bala, positionBala3, Quaternion.identity);

        (balaGenerada3.GetComponent<BalaController>()).velocityY = -1;
      }
    }

    private void GanarPuntos() {
      gmController.GanarPunto();
    }


    void OnTriggerEnter2D(Collider2D other) {
      if(other.gameObject.tag == "BALA_TAG") {
        // gmController.AddSkill("DISPARAR");
      }  
    }
}
