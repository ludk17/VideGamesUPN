package com.example.vj20231.entities;

import java.util.List;

public class Post {

    public int id;
    public String description;
    public String imageURL;
    public List<Comment> comments;


    public class Comment {
        public String comment;
    }
}
