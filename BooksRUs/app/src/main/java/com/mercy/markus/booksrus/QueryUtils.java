package com.mercy.markus.booksrus;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;



/**
 * Helper methods related to requesting and receiving data from Google's book api
 */
public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getName();
    /**
     * Query the Google Books API and return a list of {@link Books} objects.
     */
    public static List<Books> fetchBooksData(String requestUrl) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(LOG_TAG, "TEST  : Fetch Book Data" + requestUrl );


        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = "";
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        List<Books> books = extractBooksFromJson(jsonResponse);

        // Return the list of {@link Books}s
        return books;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }


    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }
    /**
     *
     *Returns a list of {@link Earthquake} objects that has been built up from
     * parsing the given JSON response.
     */


    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */


    private static List<Books> extractBooksFromJson(String booksJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(booksJSON)) {
            return null;
        }
        ArrayList<Books> books = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(booksJSON);

            JSONArray booksArray = baseJsonResponse.getJSONArray("items");

// If there are results in the features array
            if (booksArray.length() > 0) {

                // For each book in the booksArray, create an {@link Book} object
                for (int i = 0 ; i < booksArray.length() ; i++) {

                    // Get a single book at position i within the list of books
                    JSONObject bookObject = booksArray.getJSONObject(i);

                    // For a given book, extract the JSONObject associated with the
                    // key called "volumeInfo", which represents a list of all properties
                    // for that  book.
                    JSONObject volumeInfo = bookObject.getJSONObject("volumeInfo");
                    String title =  volumeInfo.getString("title");

                    String authors = "";
                    if(volumeInfo.has("authors")) {
                        JSONArray authorsArray = volumeInfo.getJSONArray("authors");
                        for (int j = 0; j < authorsArray.length(); j++) {
                            authors += volumeInfo.getString("authors");
                        }
                    }

                    String description = "";
                    if(volumeInfo.has("description")){
                        description =  volumeInfo.getString("description");
                    }

                    String imageUrl = "";
                    if (volumeInfo.has("imageLinks")){
                        JSONObject bookImage = volumeInfo.getJSONObject("imageLinks");
                        imageUrl = bookImage.getString("smallThumbnail") ;
                    }


                    // Create a new {@link Book} object with the title, author, description,
                    // and url from the JSON response.
                    Books book = new Books(title, authors, description, imageUrl );

                    // Add the new {@link Book} to the list.
                    books.add(book);
                }
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the book JSON results", e);
        }
        return books;
    }
}
