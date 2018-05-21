package com.example.android.tourguide;

/**
 * Created by ayoawotunde on 12/05/2018.
 */

public class Places {
    private String mPlace;
    private int mPhoto;
    private String mInfo;
    private String mPhone;
    private String mAddress;
    private String mSocials;
    private String mGeoLocation;
    private String mWebsite;

    public Places(String place, int photo) {
        mPlace = place;
        mPhoto = photo;
    }

    public Places(String place, int photo, String description, String phone, String address, String socials, String geo, String website) {
        mPlace = place;
        mPhoto = photo;
        mInfo = description;
        mPhone = phone;
        mAddress = address;
        mSocials = socials;
        mGeoLocation = geo;
        mWebsite = website;
    }

    public String getmPlace() {
        return mPlace;
    }

    public int getmPhoto() {
        return mPhoto;
    }

    public String getmInfo() {
        return mInfo;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmSocials() {
        return mSocials;
    }

    public String getmGeoLocation() {
        return mGeoLocation;
    }

    public String getmWebsite() {
        return mWebsite;
    }
}
