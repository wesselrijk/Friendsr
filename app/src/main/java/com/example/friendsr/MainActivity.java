package com.example.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friends.add(new Friend("Arya", "A young Stark girl, with a knack for killing.",
                getResources().getIdentifier(drawerSelection,"id",getActivity().getPackageName())); //TODO stackoverflow: https://stackoverflow.com/questions/16862000/java-android-getresources-getidentifier
        friends.add(new Friend("Cercei", "Queen or something at the moment.",
                2));
        friends.add(new Friend("Daenerys",
                "Also a queen, according to her, has dragons.",3));
        friends.add(new Friend("Jaime",
                "Cerei's liwl brother.", 4));
        friends.add(new Friend("Jon",
                "Mr. cool guy, has very nice hair, I want to know what shampoo he uses.",
                5));
        friends.add(new Friend("Jorah",
                "He's also in Game of Thrones, how nice for him.", 6));
        friends.add(new Friend("Margaery",
                "One of the characters in this series whose name starts with the letter M.",
                7));
        friends.add(new Friend("Melisandre",
                "This is the character that is played by a Dutch actress, very interesting!",
                8));
        friends.add(new Friend("Sansa",
                "Older Stark girl. Went from weak and frail to powerful and mighty! One day she will rule all of Middle Earth...",
                9));
        friends.add(new Friend("Tyrion",
                "With a name like that, everyone will take you seriously. That's a great feature to have in life!",
                10));
    }
}
