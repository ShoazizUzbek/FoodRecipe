package com.example.foodrecipe.repos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.foodrecipe.model.UserInfo;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    UserRepos userRepos;
    LiveData<List<UserInfo>> listLiveData;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepos = new UserRepos(application);
        listLiveData = userRepos.getInfo();
    }
    public LiveData<List<UserInfo>> getUserInfo(){
        return listLiveData;
    }
    public void insertOne(UserInfo category){
        userRepos.insertOne(category);
    }
}
