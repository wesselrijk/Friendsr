package com.example.friendsr;
/*
The adapter for the app is contained in this file. The adapter takes an ArrayList of type Friend
and creates
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.List;

// the FriendAdapter class is instantiated, and an ArrayList of type Friend is instantiated straight
// away
public class FriendAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friendList;

    //constructor for the FriendAdapter
    public FriendAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friendList = objects;
    }

    // an override method used to fill in the items of the GridView of the activity_main layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // if the convertView is empty, the convertView will be set to the grid_item layout
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,
                    false);
        }

        // get the Id's corresponding to the ImageView and TextView in the grid_item layout
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.name);

        // get a friend from the friendlist
        Friend current = friendList.get(position);

        // set the image and name of the friend to the grid_item
        imageView.setImageResource(current.getDrawableId());
        textView.setText(current.getName());


        // return the convertView, this will fill in the GridView of the activity_main layout
        // with images and corresponding names
        return convertView;
    }
}
