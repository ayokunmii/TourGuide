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
public class EventsFragment extends Fragment {
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

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getActivity();

        //creating objects
        final ArrayList<Places> events = new ArrayList<Places>();
        events.add(new Places(getString(R.string.event1), R.drawable.event1, getString(R.string.event1_info),
                getString(R.string.event1_phone), getString(R.string.event1_address), getString(R.string.event1_socials),
                getString(R.string.event1_geo), getString(R.string.event1_website)));
        events.add(new Places(getString(R.string.event2), R.drawable.event2, getString(R.string.event2_info),
                getString(R.string.event2_phone), getString(R.string.event2_address), getString(R.string.event2_socials),
                getString(R.string.event2_geo), getString(R.string.event2_website)));
        events.add(new Places(getString(R.string.event3), R.drawable.event3, getString(R.string.event3_info),
                getString(R.string.event3_phone), getString(R.string.event3_address), getString(R.string.event3_socials),
                getString(R.string.event3_geo), getString(R.string.event3_website)));
        events.add(new Places(getString(R.string.event4), R.drawable.event4, getString(R.string.event4_info),
                getString(R.string.event4_phone), getString(R.string.event4_address), getString(R.string.event4_socials),
                getString(R.string.event4_geo), getString(R.string.event4_website)));

        PlacesAdapter adapter = new PlacesAdapter(context, events);


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
                fragmentTransaction.replace(R.id.sub_menu, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                //initializing all variables including ones not shown in this fragment but is needed in info frag
                name = events.get(position).getmPlace();
                picture = events.get(position).getmPhoto();
                description = events.get(position).getmInfo();
                phone = events.get(position).getmPhone();
                address = events.get(position).getmAddress();
                social = events.get(position).getmSocials();
                geo = events.get(position).getmGeoLocation();
                String web = events.get(position).getmWebsite();

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
