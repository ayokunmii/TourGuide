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

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {
    public static final String PHOTO = "photo";
    public static final String NAME = "name";
    public static final String WEB = "insta page";

    int position;
    String name;
    int picture;
    String description;
    String phone;
    String address;
    String social;
    String geo;

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getActivity();

        //creating objects
        final ArrayList<Places> restaurant = new ArrayList<Places>();
        restaurant.add(new Places(getString(R.string.restaurant1), R.drawable.rest1, getString(R.string.restaurant1_info),
                getString(R.string.restaurant1_phone), getString(R.string.restaurant1_address), getString(R.string.restaurant1_socials),
                getString(R.string.restaurant1_geo), getString(R.string.restaurant1_website)));
        restaurant.add(new Places(getString(R.string.restaurant2), R.drawable.rest2, getString(R.string.restaurant2_info),
                getString(R.string.restaurant2_phone), getString(R.string.restaurant2_address), getString(R.string.restaurant2_socials),
                getString(R.string.restaurant2_geo), getString(R.string.restaurant2_website)));
        restaurant.add(new Places(getString(R.string.restaurant3), R.drawable.rest3, getString(R.string.restaurant3_info),
                getString(R.string.restaurant3_phone), getString(R.string.restaurant3_address), getString(R.string.restaurant3_socials),
                getString(R.string.restaurant3_geo), getString(R.string.restaurant3_website)));
        restaurant.add(new Places(getString(R.string.restaurant4), R.drawable.rest4, getString(R.string.restaurant4_info),
                getString(R.string.restaurant4_phone), getString(R.string.restaurant4_address), getString(R.string.restaurant4_socials),
                getString(R.string.restaurant4_geo), getString(R.string.restaurant4_website)));

        PlacesAdapter adapter = new PlacesAdapter(getActivity(), restaurant);

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
                name = restaurant.get(position).getmPlace();
                picture = restaurant.get(position).getmPhoto();
                description = restaurant.get(position).getmInfo();
                phone = restaurant.get(position).getmPhone();
                address = restaurant.get(position).getmAddress();
                social = restaurant.get(position).getmSocials();
                geo = restaurant.get(position).getmGeoLocation();
                String web = restaurant.get(position).getmWebsite();

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
