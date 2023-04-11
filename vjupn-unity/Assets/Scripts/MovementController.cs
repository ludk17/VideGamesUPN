using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovementController : MonoBehaviour
{   
    public FootController footController;
    public float jumpForce = 1000f;
    private Rigidbody2D rb;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();

    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyUp(KeyCode.Space) && footController.CanJump()) {
            rb.AddForce(transform.up * jumpForce);
            footController.Jump();
        }
    }

    private void OnTriggerEnter2D(Collider2D other) {
        if(other.gameObject.tag == "Barril") {
            // hacer algo
        }
        // Debug.Log(other.gameObject.tag);
    }


    // void OnCollisionEnter2D(Collision2D other) {
    //     Debug.Log(other.gameObject.name);
    //     canJump = true;
    // }

}
