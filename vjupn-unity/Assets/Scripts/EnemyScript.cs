using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyScript : MonoBehaviour
{
    private int colisiones = 0;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(colisiones >1) {
            Destroy(this.gameObject);
            
        }
    }

    void OnCollisionEnter2D(Collision2D other) {
        colisiones += 1;    
    }
}
