package com.example.foodrecipe.network;

import com.example.foodrecipe.model.Example;
import com.example.foodrecipe.model.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterFace {


    @GET("api/search")
    Call<Example> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

}
