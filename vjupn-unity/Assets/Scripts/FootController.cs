using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FootController : MonoBehaviour
{
    public const int MAX_JUMPS = 2;
    private bool onGround = false;
    private int currentJumps = 0;

    public bool CanJump() {
        return onGround || (!onGround && currentJumps < MAX_JUMPS);
    }

    public void Jump() {
        currentJumps++;
        onGround = false;
            
    }
    

    void OnCollisionEnter2D(Collision2D other) {
        onGround = true;
        currentJumps = 0;
    }
}
