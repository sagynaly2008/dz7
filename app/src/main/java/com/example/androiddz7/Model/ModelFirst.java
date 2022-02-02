package com.example.androiddz7.Model;

import java.io.Serializable;

public class ModelFirst implements Serializable {
    private int imageView;
    private String the_live;
    private String name;

    public ModelFirst(int imageView, String the_live, String name) {
        this.imageView = imageView;
        this.the_live = the_live;
        this.name = name;
    }

    public int getImageView() {
        return imageView;
    }


    public String getThe_live() {
        return the_live;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}