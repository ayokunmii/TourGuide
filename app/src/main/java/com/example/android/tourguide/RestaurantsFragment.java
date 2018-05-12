package com.example.android.tourguide;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getActivity();

        ArrayList<Places> restaurant = new ArrayList<Places>();
        restaurant.add(new Places(getString(R.string.restaurant1), R.mipmap.ic_sample));
        restaurant.add(new Places(getString(R.string.restaurant2), R.mipmap.ic_sample));
        restaurant.add(new Places(getString(R.string.restaurant3), R.mipmap.ic_sample));
        restaurant.add(new Places(getString(R.string.restaurant4), R.mipmap.ic_sample));

        PlacesAdapter adapter = new PlacesAdapter(getActivity(), restaurant);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);


        return rootView;


    }

}
