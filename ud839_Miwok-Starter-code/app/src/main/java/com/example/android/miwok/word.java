package com.example.android.miwok;

/**
 * Created by mesy on 08/06/17.
 */

/**
 *
 */
public class word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = N0_IMAGE_PROVIDED;

    private static final int N0_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**
     *
     * @param defaultTranslation
     * @param miwokTranslation
     * @param audioResourceId
     */
    public word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     *
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imageResourceId
     * @param audioResourceId
     */
    public word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     *
     * @return default translation
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     *
     * @return miwok translation
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }


    /**
     *
     * Returns whether or not an image exists on the view.
     */
    public boolean hasImage(){
        return mImageResourceId != N0_IMAGE_PROVIDED;

    }


    /**
     *
     * Returns audio resources
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }


    }

