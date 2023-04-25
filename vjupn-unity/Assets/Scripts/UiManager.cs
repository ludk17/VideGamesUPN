using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UiManager : MonoBehaviour
{
    public Text PuntajeText;

    public void PrintPuntaje(int puntos) {
        PuntajeText.text = "Puntaje: " + puntos;
    }
}
