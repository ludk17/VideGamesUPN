package com.example.vj20231.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.vj20231.entities.User;

import java.util.List;

@Dao
public interface UserRepository {
    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Insert
    void create(User user);
}
