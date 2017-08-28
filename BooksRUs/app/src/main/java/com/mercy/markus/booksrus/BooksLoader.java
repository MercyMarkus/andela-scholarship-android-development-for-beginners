package com.mercy.markus.booksrus;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by mesy on 23/07/17.
 */

/**
 * Loads a list of books by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class BooksLoader extends AsyncTaskLoader<List<Books>> {

    /** Tag for log messages */
    private static final String LOG_TAG = BooksLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link BooksLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */

    public BooksLoader(Context context, String url){
        super(context);
        mUrl = url;

    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "TEST  : OnStartLoading() ");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Books> loadInBackground() {

        Log.i(LOG_TAG, "TEST  : LoadInBackground() ");

        if (mUrl==null){
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Books> books = QueryUtils.fetchBooksData(mUrl);
        return books;

    }

}

