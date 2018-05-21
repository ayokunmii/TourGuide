package com.example.android.tourguide;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.tourguide.AttractionsFragment.NAME;
import static com.example.android.tourguide.AttractionsFragment.PHOTO;
import static com.example.android.tourguide.InstaFragment.ADDRESS;
import static com.example.android.tourguide.InstaFragment.GEO;
import static com.example.android.tourguide.InstaFragment.INFO;
import static com.example.android.tourguide.InstaFragment.PHONE;
import static com.example.android.tourguide.InstaFragment.SOCIAL;
import static com.example.android.tourguide.RestaurantsFragment.WEB;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesInfoFragment extends Fragment {
    TextView placeName;
    TextView desciption;
    ImageView photo;
    TextView phone;
    TextView address;
    TextView socials;
    String d;
    String g;
    String h;

    public PlacesInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.places_info, container, false);
        Context context = getActivity();
        rootView.bringToFront();

        //initialising variables
        placeName = (TextView) rootView.findViewById(R.id.name_of_location);
        desciption = (TextView) rootView.findViewById(R.id.description);
        photo = (ImageView) rootView.findViewById(R.id.image);
        phone = (TextView) rootView.findViewById(R.id.phone_contact);
        address = (TextView) rootView.findViewById(R.id.address);
        socials = (TextView) rootView.findViewById(R.id.social_instagram);

        ImageView backbutton = (ImageView) rootView.findViewById(R.id.back_button);
        ImageView homeButton = (ImageView) rootView.findViewById(R.id.home_button);


        Bundle bundle = this.getArguments();

        if (bundle != null) {
            //getting all variables from prev. fragment
            String a = bundle.getString(NAME);
            int b = bundle.getInt(PHOTO);
            String c = bundle.getString(INFO);
            d = bundle.getString(PHONE);
            String e = bundle.getString(ADDRESS);
            String f = bundle.getString(SOCIAL);
            g = bundle.getString(GEO);
            h = bundle.getString(WEB);

            //setting the variables to be used in this fragment
            placeName.setText(String.valueOf(a));
            photo.setImageResource(b);
            desciption.setText(String.valueOf(c));
            phone.setText(String.valueOf(d));
            address.setText(String.valueOf(e));
            socials.setText(String.valueOf(f));
        }

        

        //creating intents for the variables
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + d));
                getActivity().startActivity(i);

            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri gmmIntentUri = Uri.parse(g);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }

        });

        socials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(h));
                startActivity(intent);
            }
        });

        //NOTE: backbutton returns prev fragment but shows a blank screen for the listView fragments as the views here have
        // been removed when PlacesInfoFragment was opened
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(getActivity(), MainActivity.class);
                startActivity(home);
            }
        });

        return rootView;


    }

    public void onBackPressed()
    {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();

    }

}

