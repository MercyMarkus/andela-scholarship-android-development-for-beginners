package com.mercy.markus.booksrus;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Books>> {

    /* Constant with the query that indicates maxResults*/
    public static final String RESULTS = "&maxResults=15";
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String BOOK_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=subject+";
    /**
     * Constant value for the books loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOK_LOADER_ID = 1;
    /**
     * Adapter for the list of books
     */
    BooksAdapter mBooksAdapter;
    ImageButton searchButton;
    EditText inputSearch;  // Search field
    TextView emptyState;  // Empty state TextView for improving UX
    String query; // final query that contains the book search info
    LoaderManager loaderManager;
    Bundle bundle;
    View progressBar; // Progress bar for improving UX while data is fetched from server

    @Override
    public void onLoadFinished(Loader<List<Books>> loader, List<Books> data) {

        progressBar.setVisibility(View.GONE);

        emptyState.setVisibility(View.VISIBLE);
        // Set empty state text to display "No books found."
        emptyState.setText(R.string.no_books_found);

        Log.i(LOG_TAG, "TEST  : OnLoadFinished()");
        // Clear the adapter of previous earthquake data
        mBooksAdapter.clear();

        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mBooksAdapter.addAll(data);
        }

    }

    @Override
    public Loader<List<Books>> onCreateLoader(int id, Bundle args) {
        Log.i(LOG_TAG, "TEST  : OnCreateLoader ");
        // Create a new loader for the given URL
        return new BooksLoader(this, query);
    }

    @Override
    public void onLoaderReset(Loader<List<Books>> loader) {

        Log.i(LOG_TAG, "TEST  : OnLoaderReset()");
        // Loader reset, so we can clear out our existing data.
        mBooksAdapter.clear();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(LOG_TAG, "TEST  : Method OnCreate()");

        // Find a reference to the {@link ImageButton} in the layout
        searchButton = (ImageButton) findViewById(R.id.search_Button);
        // Find a reference to the {@link EditText} in the layout
        inputSearch = (EditText) findViewById(R.id.input_search);
        // Find a reference to the {@link ListView} in the layout
        ListView bookListView = (ListView) findViewById(R.id.list);
        // Find a reference to the {@link ProgressBar} in the layout
        progressBar = findViewById(R.id.progress_bar);
        // Find a reference to the {@link TextView} in the layout
        emptyState = (TextView) findViewById(R.id.info_tv);
        //Set String to emptyState textView
        emptyState.setText(R.string.search_hint);
        //Assign the emptyState to the ListView
        bookListView.setEmptyView(emptyState);
        //Remove progress bar from UI
        progressBar.setVisibility(View.GONE);

        // Create a new adapter that takes an empty list of books as input
        mBooksAdapter = new BooksAdapter(this, new ArrayList<Books>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        bookListView.setAdapter(mBooksAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        loaderManager = getLoaderManager();

        //When the activity is created, check if the loader with the BOOK_LOADER_ID exists. If exists,
        // load the information from the BOOK_LOADER_ID loader.
        if (loaderManager.getLoader(BOOK_LOADER_ID) != null) {
            loaderManager.initLoader(BOOK_LOADER_ID, bundle, MainActivity.this);
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* User Experience Set up*/
                emptyState.setVisibility(View.GONE); //Remove empty state text
                progressBar.setVisibility(View.VISIBLE); // Show progress bar until data fetching completes

                /* Append the new search query info to the default BOOK_REQUEST_URL */
                query = BOOK_REQUEST_URL + formatSearch(inputSearch.getText().toString());
                Log.i(LOG_TAG, "TEST:" + query);

                /* Get network info
                If there is connection, initialize the loader and check previous loaders
                */
                NetworkInfo networkInfo = checkInternetConnection();
                if (networkInfo != null && networkInfo.isConnected()) {

                    bundle = new Bundle();
                    bundle.putString("BOOK_API", query);

                    /*
                    * Check whether a loader with the BOOK_LOADER_ID exists or not
                    * If exists, restart the loader since a new search query was implemented
                    */
                    if (loaderManager.getLoader(BOOK_LOADER_ID) != null) {
                        loaderManager.restartLoader(BOOK_LOADER_ID, bundle, MainActivity.this);
                    }

                    // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                    // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                    // because this activity implements the LoaderCallbacks interface).
                    loaderManager.initLoader(BOOK_LOADER_ID, bundle, MainActivity.this);
                    Log.i(LOG_TAG, "TEST  : initloader() ");

                } else {
                    /*User experience set up*/
                    mBooksAdapter.clear(); //Clear the listView or adapter
                    progressBar.setVisibility(View.GONE); // Remove progress bar visibility
                    emptyState.setVisibility(View.VISIBLE); //Set emptyState text visibility
                    emptyState.setText(R.string.no_internet_connection);// Update empty state with no connection error message
                }

            }
        });

    }

    /*
  This method formats the search query of the editText. In addition it  appends maxAmount of results
   */
    private String formatSearch(String query) {

        return query.replace(" ", "+") + RESULTS;
    }

    /*
    This method uses a ConnectivityManager instance for checking the state of the Internet connection
    It will show a toast in case no Internet connection is found
     */
    private NetworkInfo checkInternetConnection() {

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {

            Toast.makeText(getApplicationContext(), " No Internet Connection", Toast.LENGTH_LONG).show();

        }
        return info;
    }


}
