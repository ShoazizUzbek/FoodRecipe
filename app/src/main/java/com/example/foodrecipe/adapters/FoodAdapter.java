package com.example.foodrecipe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodrecipe.R;
import com.example.foodrecipe.model.Menu;

import java.util.List;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    Context context;
    List<Menu>  menuList;
    public FoodAdapter(List<Menu> drugList, Context context) {
        this.context = context;
        this.menuList = drugList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_list,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Menu menu = menuList.get(i);
        myViewHolder.textView.setText(menu.getTitle());
        Glide.with(context).load(menu.getImage_url()).into(myViewHolder.img);


    }




    @Override
    public int getItemCount(){
        return menuList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.img_title);
            img = itemView.findViewById(R.id.recipe_img);
        }
    }
}
