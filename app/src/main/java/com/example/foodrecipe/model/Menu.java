package com.example.foodrecipe.model;

public class Menu {
   private String image_url;
   private String title;

    public String getImage_url() {
        return image_url;
    }

    public Menu(String image_url, String title) {
        this.image_url = image_url;
        this.title = title;
    }

    public Menu() {
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
