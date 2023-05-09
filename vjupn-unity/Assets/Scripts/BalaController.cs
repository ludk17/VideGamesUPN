using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BalaController : MonoBehaviour
{
    private GameObject gmObject;
    public float velocityX = 0.1f;
    public float velocityY = 0f;
    Rigidbody2D rb;
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();
        gmObject = GameObject.Find("GameManagerObject");

        

        Destroy(this.gameObject, 5);
    }

    // Update is called once per frame
    void Update()
    {
        rb.velocity = new Vector2(velocityX, velocityY);
    }

    void OnTriggerEnter2D(Collider2D other) {
        Debug.Log("trigger");
        Debug.Log(other.gameObject.name);
        Destroy(this.gameObject);
    }
}
