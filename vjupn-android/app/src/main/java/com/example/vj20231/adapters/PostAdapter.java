package com.example.vj20231.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vj20231.CommentActivity;
import com.example.vj20231.R;
import com.example.vj20231.entities.Post;
import com.example.vj20231.entities.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {

    private List<Post> items;

    public PostAdapter(List<Post> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_post, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post item = items.get(position);
        View view = holder.itemView;

        // construyo el item

        TextView tvDescription = view.findViewById(R.id.tvDescripcion);
        tvDescription.setText(item.description);
        ImageView imgFoto = view.findViewById(R.id.ivPost);

        String url = "https://demo-upn.bit2bittest.com" + item.imageURL;

        Picasso.get().load(url).into(imgFoto);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CommentActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
