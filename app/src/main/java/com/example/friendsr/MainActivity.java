package com.example.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friends.add(new Friend("Arya", "A young Stark girl, with a knack for killing.",
                R.drawable.arya)); //TODO stackoverflow: https://stackoverflow.com/questions/16862000/java-android-getresources-getidentifier
        // https://stackoverflow.com/questions/15488238/using-android-getidentifier
        // ImageViewReference.setImageResource(aDrawableId) heeft hier ook mee te maken
        friends.add(new Friend("Cersei", "Queen or something at the moment.",
                R.drawable.cersei));
        friends.add(new Friend("Daenerys",
                "Also a queen, according to her, has dragons.", R.drawable.daenerys));
        friends.add(new Friend("Jaime",
                "Cerei's liwl brother.", R.drawable.jaime));
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
                "Older Stark girl. Went from weak and frail to powerful and mighty! One day she will rule all of Middle Earth...",
                R.drawable.sansa));
        friends.add(new Friend("Tyrion",
                "With a name like that, everyone will take you seriously. That's a great feature to have in life!",
                R.drawable.tyrion));

        // set adapter to gridview View
        GridView gridView = findViewById(R.id.grid_view);
        FriendAdapter adapter = new FriendAdapter(this, R.layout.grid_item, friends);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
