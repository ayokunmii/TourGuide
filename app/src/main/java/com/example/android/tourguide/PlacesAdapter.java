package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.Places;
import com.example.android.tourguide.R;

import java.util.ArrayList;

/**
 * Created by ayoawotunde on 12/05/2018.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {


    public PlacesAdapter (Context context, ArrayList<Places>places){
        super(context,0,places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Places place_name = getItem(position);
        TextView placeName = (TextView) listItemView.findViewById(R.id.place);
        placeName.setText(place_name.getmPlace());
        Places image =getItem(position);
        ImageView imageView =(ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(image.getmPhoto());

        return listItemView;
    }
}
