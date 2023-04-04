using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float xVelocity = 10f;
    public float jumpForce = 400f;
    // Start is called before the first frame update
    private Rigidbody2D rb;
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {
        var yVelocity = rb.velocity.y;
        
        rb.velocity = new Vector2(0, yVelocity);
        
        if(Input.GetKey(KeyCode.RightArrow))
            rb.velocity = new Vector2(xVelocity, yVelocity);
        if(Input.GetKey(KeyCode.LeftArrow))
            rb.velocity = new Vector2(-xVelocity, yVelocity);
        if(Input.GetKeyUp(KeyCode.Space))
            rb.AddForce(transform.up * jumpForce);
    }
}
