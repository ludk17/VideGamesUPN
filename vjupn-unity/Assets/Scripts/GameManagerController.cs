using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameManagerController : MonoBehaviour
{
    GameData gameData = new GameData();
    GameRepository gameRepository;
    Text scoreText;
    Text vidasText;
    void Start() {
        
        gameRepository = GetComponent<GameRepository>();

        scoreText = GameObject.Find("/Canvas/ScoreText").GetComponent<Text>();
        vidasText = GameObject.Find("/Canvas/VidasText").GetComponent<Text>();

        gameData = gameRepository.GetSavedData();

        LoadScreenTexts();
    }

    void LoadScreenTexts() {
        scoreText.text = $"Puntaje: {gameData.Score}";
        vidasText.text = $"Puntaje: {gameData.Vidas}";
    }

    public void GanarPunto() {
        gameData.Score++;
        gameRepository.SaveData(gameData);
        LoadScreenTexts();
    }

    public List<string> GetSkills() {
        return gameData.Skills;
    }
}
