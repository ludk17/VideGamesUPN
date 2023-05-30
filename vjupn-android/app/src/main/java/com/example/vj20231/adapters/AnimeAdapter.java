package com.example.vj20231.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vj20231.Clases.Anime;
import com.example.vj20231.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter {

    private List<Anime> animeList;
    private Context context;

    public AnimeAdapter(List<Anime> animeList, Context context){
        this.animeList = animeList;
        this.context =context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_anime, parent, false);
        AnimeAdapter.NameViewHolder viewHolder = new AnimeAdapter.NameViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String nombre = animeList.get(position).getNombre();
        String descripcion = animeList.get(position).getDescripcion();
        String imagen = animeList.get(position).getImagen();
        Boolean favorito = animeList.get(position).getFav();

        View view = holder.itemView;

        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvDescripcion = view.findViewById(R.id.tvDescripcion);
        ImageView imgFoto = view.findViewById(R.id.imgFoto);
        ImageButton imgEstrella = view.findViewById(R.id.imgEstrella);

        int po = position;
        tvNombre.setText(nombre.toString());
        tvDescripcion.setText(descripcion.toString());

        Picasso.get().load(imagen)
                .resize(200, 200)
                .into(imgFoto);



        if(favorito){
            imgEstrella.setImageResource(R.drawable.starfav);
        }else {
            imgEstrella.setImageResource(R.drawable.starnofav);
        }

        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(animeList.get(po).getFav()){
                    animeList.get(po).setFav(false);
                    imgEstrella.setImageResource(R.drawable.starnofav);
                } else {
                    animeList.get(po).setFav(true);
                    imgEstrella.setImageResource(R.drawable.starfav);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
