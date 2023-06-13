package com.example.vj20231.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vj20231.R;
import com.example.vj20231.entities.Comment;
import com.example.vj20231.entities.Post;

import org.w3c.dom.Text;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private List<Comment> items;

    public CommentAdapter(List<Comment> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_comment, parent, false);
        CommentViewHolder viewHolder = new CommentViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comment item = items.get(position);
        View view = holder.itemView;

        // construyo el item

        TextView tvComment = view.findViewById(R.id.tvComment);
        tvComment.setText(item.comment);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
