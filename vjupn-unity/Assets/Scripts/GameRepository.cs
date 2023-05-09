using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using UnityEngine;

public class GameRepository : MonoBehaviour
{


    public void SaveData(GameData data) {
        string destination = Application.persistentDataPath + "/save.dat";
        FileStream file;

        if(File.Exists(destination)) 
            file = File.OpenWrite(destination);
        else 
            file = File.Create(destination);
        
        BinaryFormatter bf = new BinaryFormatter();
        bf.Serialize(file, data);
        file.Close();
    }

    public GameData GetSavedData() {

        Debug.Log("Loading file save.dat");

        string destination = Application.persistentDataPath + "/save.dat";
        FileStream file;

        if(File.Exists(destination))  {
            file = File.OpenRead(destination);
        } 
        else {
            return new GameData();
        }

        BinaryFormatter bf = new BinaryFormatter();
        GameData data = (GameData) bf.Deserialize(file);
        file.Close();

        return data;

     
    }

    
}
