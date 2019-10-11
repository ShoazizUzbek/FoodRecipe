package com.example.foodrecipe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.foodrecipe.model.UserInfo;

@Database(entities = {UserInfo.class}, version = 1)
public abstract class DataBaseHelper extends RoomDatabase {
    public abstract UserDao categoryDao();


    private static DataBaseHelper instance;
    private static final String DB_NAME = "awesomefood.db";
    public static DataBaseHelper getDatabase(final Context context) {
        if (instance == null) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        DataBaseHelper.class, DB_NAME)
                        .build();
            }
        }
        return instance;
    }
}
