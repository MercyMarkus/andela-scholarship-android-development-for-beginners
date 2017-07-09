package com.mercy.markus.tourkadunacity;


import android.location.Location;

public class Destination {
    private String mDestinationName;
    private String mDestinationNumber;
    private String mDestinationAddress;
    private int mImageResourceId;
    private Location mDestinationLocation;


    /**
     *
     * @param DestinationName
     * @param DestinationNumber
     * @param DestinationAddress
     * @param ImageResourceId
     * @param location
     */
    public Destination (String DestinationName, String DestinationNumber,
                        String DestinationAddress, int ImageResourceId, Location location){
        mDestinationName = DestinationName;
        mDestinationNumber = DestinationNumber;
        mDestinationAddress = DestinationAddress;
        mImageResourceId = ImageResourceId;
        mDestinationLocation = location;
    }

    /**
     *
     * @return Name of Destination
     */
    public String getDestinationName(){
        return mDestinationName;
    }

    /**
     *
     * @return Number of Destination
     */
    public String getDestinationNumber(){
        return mDestinationNumber;
    }

    /**
     *
     * @return Address of Destination
     */
    public String getDestinationAddress(){
        return mDestinationAddress;
    }

    /**
     *
     * @return Image of Destination
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }


    public Location getDestinationLocation(){
        return mDestinationLocation;
    }
}