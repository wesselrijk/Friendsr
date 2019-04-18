package com.example.friendsr;
/*
The activity for the ProfileActivity is handled in this file. Here a new layout is set to the
screen (the old one will not be 'finished'), displaying the profile picture, an errorbar and the
name and bio of the friend that was clicked. The rating on the ratingbar can be changed, and this
setting will be saved.
 */

// list of imports
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


// instantiate the ProfileActivity class
public class ProfileActivity extends AppCompatActivity {

    // instantiate a variable for the name of a friend
    private String friendName;

    // in the onCreate, the activity_profile layout is being set and SharedPreferences are loaded
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // get intent and the Friend from the serializable extra when its picture has been clicked
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // set the name to the friendName and find the storedRating for this friend, default value
        // will be zero but it will display a saved rating if the rating has been changed by the
        // user
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

    // method for the listener of the ratingbar, should be activated when a ratingbar is incremented
    private class ProfileActivityBarChangeListener implements RatingBar.OnRatingBarChangeListener {

        // the override is incremented when a rating of a ratingbar has been changed after which an
        // editor will be made for the SharedPreferences, in which a rating will be saved for a
        // friendname, so it can be acquired when revisiting the ProfileActivity layout
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings",
                    MODE_PRIVATE).edit();
            editor.putFloat(friendName, rating);
            editor.apply();
        }
    }
}
