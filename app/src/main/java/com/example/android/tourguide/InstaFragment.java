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

import static com.example.android.tourguide.RestaurantsFragment.WEB;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstaFragment extends Fragment {
    public static final String PHOTO = "photo";
    public static final String NAME = "name";
    public static final String INFO = "description";
    public static final String PHONE = "contact no";
    public static final String ADDRESS = "add";
    public static final String SOCIAL = "instagram";
    public static final String GEO = "long and lat";

    int position;
    String name;
    int picture;
    String description;
    String phone;
    String address;
    String social;
    String geo;

    public InstaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.sub_menu_list, container, false);
        Context context = getContext();

        //creating objects
        final ArrayList<Places> insta = new ArrayList<Places>();
        insta.add(new Places(getString(R.string.insta1), R.drawable.insta1, getString(R.string.insta1_info),
                getString(R.string.insta1_phone), getString(R.string.insta1_address), getString(R.string.insta1_socials),
                getString(R.string.insta1_geo), getString(R.string.insta1_website)));
        insta.add(new Places(getString(R.string.insta2), R.drawable.insta2, getString(R.string.insta2_info),
                getString(R.string.insta2_phone), getString(R.string.insta2_address), getString(R.string.insta2_socials),
                getString(R.string.insta2_geo), getString(R.string.insta2_website)));
        insta.add(new Places(getString(R.string.insta3), R.drawable.insta3, getString(R.string.insta3_info),
                getString(R.string.insta3_phone), getString(R.string.insta3_address), getString(R.string.insta3_socials),
                getString(R.string.insta3_geo), getString(R.string.insta3_website)));
        insta.add(new Places(getString(R.string.insta4), R.drawable.insta4, getString(R.string.insta4_info),
                getString(R.string.insta4_phone), getString(R.string.insta4_address), getString(R.string.insta4_socials),
                getString(R.string.insta4_geo), getString(R.string.insta4_website)));

        PlacesAdapter adapter = new PlacesAdapter(context, insta);

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
                name = insta.get(position).getmPlace();
                picture = insta.get(position).getmPhoto();
                description = insta.get(position).getmInfo();
                phone = insta.get(position).getmPhone();
                address = insta.get(position).getmAddress();
                social = insta.get(position).getmSocials();
                geo = insta.get(position).getmGeoLocation();
                String web = insta.get(position).getmWebsite();

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
