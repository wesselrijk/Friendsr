package com.example.friendsr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

// import ArrayAdapter; standard import provided by android-studio

public class FriendAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friendList;

    //constructor
    public FriendAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
    }

    // getView() override
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        return convertView;
    }
}
