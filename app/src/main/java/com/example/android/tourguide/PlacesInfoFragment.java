package com.example.android.tourguide;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
            String a = bundle.getString(NAME);
            int b = bundle.getInt(PHOTO);
            String c = bundle.getString(INFO);
            d = bundle.getString(PHONE);
            String e = bundle.getString(ADDRESS);
            String f = bundle.getString(SOCIAL);
            g = bundle.getString(GEO);
            h = bundle.getString(WEB);

            placeName.setText(String.valueOf(a));
            photo.setImageResource(b);
            desciption.setText(String.valueOf(c));
            phone.setText(String.valueOf(d));
            address.setText(String.valueOf(e));
            socials.setText(String.valueOf(f));
        }

        final ArrayList<Places> fulldescript = new ArrayList<Places>();
        fulldescript.add(new Places(getString(R.string.attract1), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract2), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract3), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract4), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract1), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract2), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract3), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract4), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract1), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract2), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract3), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.attract4), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.restaurant1), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.restaurant2), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.restaurant3), R.mipmap.ic_sample));
        fulldescript.add(new Places(getString(R.string.restaurant4), R.mipmap.ic_sample));
        
        PlacesInfoAdapter adapter = new PlacesInfoAdapter(getActivity(), fulldescript);
        
        

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
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(g);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                // Attempt to start an activity that can handle the Intent
                if (mapIntent.getComponent() != null) {

                }
            }

        });

        socials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(h));
                startActivity(intent);
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    public  Intent newInstagramProfileIntent(PackageManager pm, String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            if (pm.getPackageInfo("com.instagram.android", 0) != null) {
                if (url.endsWith("/")) {
                    url = url.substring(0, url.length() - 1);
                }
                final String username = url.substring(url.lastIndexOf("/") + 1);
                intent.setData(Uri.parse("http://instagram.com/_u/" + username));
                intent.setPackage("com.instagram.android");
                return intent;
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.stackoverflow.com"));
                startActivity(i);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        intent.setData(Uri.parse(url));
        return intent;
    }

}

