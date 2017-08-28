package com.mercy.markus.booksrus;

/**
 * Created by mesy on 21/07/17.
 */

public class Books {
    private String mImageResourceId;
    private String mBookTitle;
    private String mAuthors;
    private String mBookDescription;
    /*private float mRating;
    private String mUrl;*/

    public   Books(String ImageResourceId, String BookTitle, String Authors, String BookDescription){
        mImageResourceId = ImageResourceId;
        mBookTitle = BookTitle;
        mBookDescription = BookDescription;
        mAuthors = Authors;
  /*      mUrl =Url;
        mRating = Rating;*/
    }

    /**
     *
     * @return Book Cover Image
     */
    public String getImageResourceId(){
        return mImageResourceId;
    }

    /**
     *
     * @return Title of Book
     */
    public String getBookTitle(){
        return mBookTitle;
    }

    /**
     *
     * @return Name Of Authors
     */
    public String getAuthors(){
        return mAuthors;
    }

    /**
     *
     * @return Description Of Books
     */
    public String getBookDescription(){
        return mBookDescription;
    }

   /* *//**
     *
     * @return Rating for Book
     *//*
    public float getRating(){
        return mRating;
    }

    *//**
     *
     * @return Book Url
     *//*
    public String getUrl(){
        return mUrl;
    }*/

}
