package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vj20231.Clases.Anime;
import com.example.vj20231.adapters.AnimeAdapter;
import com.example.vj20231.adapters.NameAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaAnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anime);

        AnimeAdapter adapter = new AnimeAdapter(data(), this);

        RecyclerView rvLista =  findViewById(R.id.rvListaAnime);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    private List<Anime> data(){
        List<Anime> animeList =new ArrayList<>();

        Anime a0 = new Anime("Jujutsu Kaisen", "Anime de hechizeros que se enfrentan a demonios", "https://m.media-amazon.com/images/I/81s+jxE5KEL.jpg", false);
        animeList.add(a0);
        Anime a1 = new Anime("Hyouka", "Anime de misterio escolar", "https://i.etsystatic.com/33708229/r/il/b21027/3774911383/il_570xN.3774911383_696a.jpg", true);
        animeList.add(a1);
        Anime a2 = new Anime("Attack on Titan", "Anime de humanos contra titanes", "https://i.pinimg.com/originals/fe/a2/87/fea287275342bca7930ae82f9fd004ca.jpg", false);
        animeList.add(a2);
        Anime a3 = new Anime("My Hero Academia", "Anime de superheroes", "https://images-cdn.ubuy.co.in/634d2fcb85a43375cc21cf05-room-aesthetics-minimalist-anime-poster.jpg", true);
        animeList.add(a3);
        Anime a4 = new Anime("One Piece", "Anime de piratas", "https://static.posters.cz/image/350/posters/one-piece-wano-i149539.jpg", true);
        animeList.add(a4);



        return animeList;
    }
}