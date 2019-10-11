package com.example.foodrecipe.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.foodrecipe.R;
import com.example.foodrecipe.adapters.FoodAdapter;
import com.example.foodrecipe.model.Example;
import com.example.foodrecipe.model.Menu;
import com.example.foodrecipe.network.ApiClient;
import com.example.foodrecipe.network.ApiInterFace;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {


    public FavouriteFragment() {
        // Required empty public constructor
    }
    private GridLayoutManager mGridLayoutManager;

    ProgressBar progressBar;

    RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    List<Menu> menus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        progressBar = view.findViewById(R.id.progress_favourite);
        recyclerView = view.findViewById(R.id.recycler_favourite);
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        loadMenu();
        return view;
    }
    private void loadMenu() {
        ApiInterFace apiInterface = ApiClient.apiRequest().create(ApiInterFace.class);
        Call<Example> call = apiInterface.searchRecipe("28ecb84c6a07f38af498f383d6a0bc2d","chicken%20breast","1");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Toast.makeText(getContext(), ""+ response.isSuccessful(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()&& response!=null){
                    List<Menu> menus = response.body().getMenus();
                    foodAdapter = new FoodAdapter(menus,getContext());
                    recyclerView.setAdapter(foodAdapter);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // Toast.makeText(getContext(), "Network failed", Toast.LENGTH_SHORT).show();
                //loadOffline();
                Log.d("logged", "onFailure: "+t.getMessage());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void loadOffline() {
        Log.d("tagged", "loadOffline: ");
        List<Menu> menus = new ArrayList<>();

        Menu menu = new Menu();
        menu.setTitle("Chicken and cashew nut stir-fry");
        menu.setImage_url("http://static.food2fork.com/chickenandcashewnuts_89299_16x9986b.jpg");
        Menu menu1 = new Menu("http://static.food2fork.com/466_1_1349094314_lrg2129.jpg","Roasted chicken breast with pancetta");
        Menu menu2 = new Menu("http://static.food2fork.com/2028272b37.jpg","Buffalo Chicken Chili");
        Menu menu3 = new Menu("http://static.food2fork.com/1364637_MEDIUMc356.jpg","Chicken breast with avocado salad");
        Menu menu4 = new Menu("http://static.food2fork.com/1768256a59.jpg","Simply Parmesan Chicken");
        Menu menu5 = new Menu("http://static.food2fork.com/chickenbiriyani_89035_16x90f07.jpg","Chicken biryani");
        Menu menu6 = new Menu("http://static.food2fork.com/2028272b37.jpg","Buffalo Chicken Chili");
        Menu menu7 = new Menu("http://static.food2fork.com/1364637_MEDIUMc356.jpg","Chicken breast with avocado salad");
        Menu menu8 = new Menu("http://static.food2fork.com/mare_chicken_parmesan_h176c.jpg","Chicken Parmesan");
        Menu menu9 = new Menu("http://static.food2fork.com/1145661_MEDIUM627e.jpg","Artichoke, chicken &amp; lemon linguine");
        Menu menu10 = new Menu("http://static.food2fork.com/333612_MEDIUM064c.jpg","Chicken with lemon &amp; courgette couscous");
        Menu menu11 = new Menu("http://static.food2fork.com/1562652_MEDIUM1004.jpg","Posh chicken nuggets");
        Menu menu12 = new Menu("http://static.food2fork.com/197075_medium0a7a.jpg","Chicken &amp; Sweetcorn Soup");



        menus.add(menu);
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu6);
        menus.add(menu7);
        menus.add(menu8);
        menus.add(menu9);
        menus.add(menu10);
        menus.add(menu11);
        menus.add(menu12);

        foodAdapter = new FoodAdapter(menus,getContext());
        recyclerView.setAdapter(foodAdapter);
    }


}
