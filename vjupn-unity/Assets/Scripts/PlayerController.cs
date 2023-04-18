using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public GameObject bala;
    private Rigidbody2D rb;
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
    }

    void Update()
    {
       if(Input.GetKeyUp(KeyCode.U)) {
         // crear a la bala
         // que objeto
         // en donde debe aparecer
         // que rotacion va a tener?
         var currentPosition = transform.position;
         var position = new Vector3(currentPosition.x - 5, currentPosition.y, 10);
         var balaGO = Instantiate(bala, position, Quaternion.identity);
         var controller = balaGO.GetComponent<BalaController>();
         controller.velocityX = -1f;
       }
    }
}
