package com.example.foodrecipe.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodrecipe.model.UserInfo;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertOneCategory(UserInfo category);

    @Query("SELECT * FROM user ORDER BY name ASC")
    LiveData<List<UserInfo>> getAllCategories();

}
