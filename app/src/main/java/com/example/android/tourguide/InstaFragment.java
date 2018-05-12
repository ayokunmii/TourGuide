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
public class InstaFragment extends Fragment {


    public InstaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getActivity();

        ArrayList<Places> insta = new ArrayList<Places>();
        insta.add(new Places(getString(R.string.attract1), R.mipmap.ic_sample));
        insta.add(new Places(getString(R.string.attract2), R.mipmap.ic_sample));
        insta.add(new Places(getString(R.string.attract3), R.mipmap.ic_sample));
        insta.add(new Places(getString(R.string.attract4), R.mipmap.ic_sample));

        PlacesAdapter adapter = new PlacesAdapter(getActivity(), insta);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);


        return rootView;

    }

}
