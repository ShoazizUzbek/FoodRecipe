package com.example.foodrecipe.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("recipes")
    List<Menu>  menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
