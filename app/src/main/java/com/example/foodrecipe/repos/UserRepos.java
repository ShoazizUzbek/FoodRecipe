package com.example.foodrecipe.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.foodrecipe.db.DataBaseHelper;
import com.example.foodrecipe.db.UserDao;
import com.example.foodrecipe.model.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserRepos {

    private UserDao categoryDao;
    private LiveData<List<UserInfo>> allCategory;

    public UserRepos(Application application){
        DataBaseHelper myDatabase = DataBaseHelper.getDatabase(application);
        categoryDao = myDatabase.categoryDao();
        allCategory = categoryDao.getAllCategories();
    }
    public LiveData<List<UserInfo>> getInfo() {
        return allCategory;
    }

    public void insertOne(final UserInfo category){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryDao.insertOneCategory(category);
            }
        });
    }
}
