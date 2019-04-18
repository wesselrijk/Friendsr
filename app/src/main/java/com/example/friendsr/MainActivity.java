package com.example.friendsr;
/*
The MainActivity for the Friends app, contains the MainActivity class. A friend list is instantiated
and added to in the onCreate. Then an adapter is made which is set to the GridView of the
activity_main layout. Also an onItemClickListener is set to the GridView. When an item on the
GridView is clicked the method GridItemClickListener will be implied, activating the second
activity.
 */

// list of imports
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RatingBar;
import java.util.ArrayList;

// MainActivity class is instantiated, an ArrayList of Friend objects is instantiated straight away
public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make some Friend objects to add them to the list of friends, linked to images in drawable
        friends.add(new Friend("Arya", "A young Stark girl, with a knack for killing.",
                R.drawable.arya));
        friends.add(new Friend("Cersei", "Queen or something at the moment.",
                R.drawable.cersei));
        friends.add(new Friend("Daenerys",
                "Also a queen, according to her, has dragons.", R.drawable.daenerys));
        friends.add(new Friend("Jaime",
                "Cersei's liwl brother.", R.drawable.jaime));
        friends.add(new Friend("Jon",
                "Mr. cool guy, has very nice hair, I want to know what shampoo he uses.",
                R.drawable.jon));
        friends.add(new Friend("Jorah",
                "He's also in Game of Thrones, how nice for him.", R.drawable.jorah));
        friends.add(new Friend("Margaery",
                "One of the characters in this series whose name starts with the letter M.",
                R.drawable.margaery));
        friends.add(new Friend("Melisandre",
                "This is the character that is played by a Dutch actress, very interesting!",
                R.drawable.melisandre));
        friends.add(new Friend("Sansa",
                "Older Stark girl. Went from weak and frail to powerful and mighty! One day"
                        + " she will rule all of Middle Earth...",
                R.drawable.sansa));
        friends.add(new Friend("Tyrion",
                "With a name like that, everyone will take you seriously. That's a great "
                        + "feature to have in life!",
                R.drawable.tyrion));

        // create an adapter of the FriendAdapter class, finds the grid view of the activity_main
        // layout, sets the adapter to it and an onItemClickListener
        FriendAdapter adapter = new FriendAdapter(this, R.layout.grid_item, friends);
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    // method that should be activated when a grid item is clicked
    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        // the onItemClick here provides the parent and the position of the grid item that has been
        // clicked
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // a friend object clickFriend is created for the griditem that has been clicked, using
            // an intent the activity ProfileActivity will be started, taking the clickedFriend to
            // be used in the activity
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
