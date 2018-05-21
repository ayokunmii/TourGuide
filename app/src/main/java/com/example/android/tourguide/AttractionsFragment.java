package com.example.android.tourguide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.tourguide.InstaFragment.ADDRESS;
import static com.example.android.tourguide.InstaFragment.GEO;
import static com.example.android.tourguide.InstaFragment.INFO;
import static com.example.android.tourguide.InstaFragment.PHONE;
import static com.example.android.tourguide.InstaFragment.SOCIAL;
import static com.example.android.tourguide.RestaurantsFragment.WEB;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {
    public static final String PHOTO = "photo";
    public static final String NAME = "name";

    int position;
    String name;
    int picture;
    String description;
    String phone;
    String address;
    String social;
    String geo;

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getActivity();


        //creating objects
        final ArrayList<Places> attractions = new ArrayList<Places>();
        attractions.add(new Places(getString(R.string.attract1), R.drawable.attract1, getString(R.string.attract1_info),
                getString(R.string.attract1_phone), getString(R.string.attract1_address), getString(R.string.attract1_socials),
                getString(R.string.attract1_geo), getString(R.string.attract1_website)));
        attractions.add(new Places(getString(R.string.attract2), R.drawable.attract2, getString(R.string.attract2_info),
                getString(R.string.attract2_phone), getString(R.string.attract2_address), getString(R.string.attract2_socials),
                getString(R.string.attract2_geo), getString(R.string.attract2_website)));
        attractions.add(new Places(getString(R.string.attract3), R.drawable.attract3, getString(R.string.attract3_info),
                getString(R.string.attract3_phone), getString(R.string.attract3_address), getString(R.string.attract3_socials),
                getString(R.string.attract3_geo), getString(R.string.attract3_website)));
        attractions.add(new Places(getString(R.string.attract4), R.drawable.attract4, getString(R.string.attract4_info),
                getString(R.string.attract4_phone), getString(R.string.attract4_address), getString(R.string.attract4_socials),
                getString(R.string.attract4_geo), getString(R.string.attract4_website)));

        PlacesAdapter adapter = new PlacesAdapter(context, attractions);

        ListView listView = (ListView) rootView.findViewById(R.id.list_item);
        listView.setAdapter(adapter);


        //setting clickListener to open a new fragment with more info on the place
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                LinearLayout remove = (LinearLayout) rootView.findViewById(R.id.sub_menu);
                remove.removeAllViewsInLayout();
                PlacesInfoFragment fragment2 = new PlacesInfoFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace((R.id.sub_menu), fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                //initializing all variables including ones not shown in this fragment but is needed in info frag
                name = attractions.get(position).getmPlace();
                picture = attractions.get(position).getmPhoto();
                description = attractions.get(position).getmInfo();
                phone = attractions.get(position).getmPhone();
                address = attractions.get(position).getmAddress();
                social = attractions.get(position).getmSocials();
                geo = attractions.get(position).getmGeoLocation();
                String web = attractions.get(position).getmWebsite();

                //putting all variables in a bundle
                Bundle bundle = new Bundle();
                bundle.putString(NAME, name);
                bundle.putInt(PHOTO, picture);
                bundle.putString(INFO, description);
                bundle.putString(PHONE, phone);
                bundle.putString(ADDRESS, address);
                bundle.putString(SOCIAL, social);
                bundle.putString(GEO, geo);
                bundle.putString(WEB, web);
                fragment2.setArguments(bundle);

            }
        });

        //intent to home screen
        ImageView homeButton = (ImageView) rootView.findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homePage = new Intent(getActivity(), MainActivity.class);
                startActivity(homePage);
            }
        });


        return rootView;
    }


}
