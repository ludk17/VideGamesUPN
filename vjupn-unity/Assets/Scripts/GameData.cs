using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[System.Serializable]
public class GameData
{
    public int Vidas;
    public int Score;
    public List<string> Skills;
    public GameData()
    {
        Score = 0;
        Vidas = 3;
        Skills = List<string>();
    }
}
