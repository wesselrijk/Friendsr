package com.example.friendsr;
/*
The Friend class will be contained in this file.
 */

// import used
import java.io.Serializable;

// the Friend class is instantiated here, taking a name, bio, drawableId and rating as variables
public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    // constructor setting the name, bio and drawableID for the object, rating is not set yet
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
