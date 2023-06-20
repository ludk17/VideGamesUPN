package com.example.vj20231.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey()
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    public String username;
    public String email;
    public String apellido;
}
