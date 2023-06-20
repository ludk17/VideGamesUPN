package com.example.vj20231.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.vj20231.entities.User;
import com.example.vj20231.repositories.UserRepository;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserRepository userRepository();

    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "vj20231")
                .allowMainThreadQueries()
                .build();
    }

}
