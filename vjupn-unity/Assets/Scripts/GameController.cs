using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameController : MonoBehaviour
{

    public SpriteRenderer Character;
    public Sprite[] Sprites;

    private int currentImage = 0;
    // Start is called before the first frame update

    // Update is called once per frame
    void Update()
    {
        Character.sprite = Sprites[currentImage];
        if(Input.GetKeyUp(KeyCode.RightArrow)) {
            currentImage = currentImage == 0 ? 1 : 0;
        }
        if(Input.GetKeyUp(KeyCode.LeftArrow)) {
            currentImage = currentImage == 0 ? 1 : 0;
        }
    }
}
