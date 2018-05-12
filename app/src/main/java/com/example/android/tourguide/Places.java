package com.example.android.tourguide;

/**
 * Created by ayoawotunde on 12/05/2018.
 */

public class Places {
    private String mPlace;
    private int mPhoto;

    public Places (String place, int photo){
        mPlace = place;
        mPhoto = photo;
    }

    public String getmPlace() {
        return mPlace;
    }

    public int getmPhoto() {
        return mPhoto;
    }
}
