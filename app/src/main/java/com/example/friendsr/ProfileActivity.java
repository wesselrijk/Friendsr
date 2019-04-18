package com.example.friendsr;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    // instantiate a variable for the name of a friend
    private String friendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // get intent and get the Friend from the serializable extra when its picture has been clicked
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // set the name to the friendName and find the storedRating for this friend
        friendName = retrievedFriend.getName();
        Float storedRating = prefs.getFloat(friendName, 0.0f);

        // find views
        ImageView profileImage = findViewById(R.id.profileImage);
        TextView profileName = findViewById(R.id.profileName);
        TextView profileBio = findViewById(R.id.profileBio);
        RatingBar profileRating = findViewById(R.id.ratingBar);

        // set views to saved values
        profileImage.setImageResource(retrievedFriend.getDrawableId());
        profileName.setText(retrievedFriend.getName());
        profileBio.setText(retrievedFriend.getBio());
        profileRating.setRating(storedRating);

        // set the listener to the ratingbar
        profileRating.setOnRatingBarChangeListener(new ProfileActivityBarChangeListener());
    }

    private class ProfileActivityBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(friendName, rating);
            editor.apply();
        }
    }
}
