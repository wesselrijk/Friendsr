package com.example.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    // constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for bio
    public String getBio() {
        return bio;
    }

    // getter for drawableId
    public int getDrawableId() {
        return drawableId;
    }

    // setter for rating
    public void setRating(float rating) {
        this.rating = rating;
    }
}
