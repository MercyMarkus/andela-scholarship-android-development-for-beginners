package com.mercy.markus.booksrus;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mesy on 21/07/17.
 */

/**
 * {@link BooksAdapter}is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Books} objects.
 */
 public class BooksAdapter extends ArrayAdapter<Books> {

    private Books currentBook;
    private Context context;

     public BooksAdapter(Activity context, List<Books> booksList ){
        super(context, 0, booksList);
         this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        currentBook = getItem(position);

        //Find the ImageView with the view ID imageView for setting the picture of the book
        ImageView bookImageView = (ImageView) listItemView.findViewById(R.id.book_image);

        //Check if the currentBook has an empty imageUrl / path. If so, remove visibility of the
        //imageView. Otherwise use picasso library and show the image
        if (currentBook.getImageResourceId() ==  null || currentBook.getImageResourceId().isEmpty() ){
            bookImageView.setVisibility(View.GONE);
        }else {
            //Implement library specific code lines for adding the image url
            Picasso.with(context)
                    .load(currentBook.getImageResourceId())
                    .into(bookImageView);
        }

        // Find the TextView with view ID tv1 for setting title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.book_title) ;
        // Display the magnitude of the current book in that TextView
        titleTextView.setText(currentBook.getBookTitle()) ;

        // Find the TextView with view ID tv2 for setting author
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.book_author) ;
        // Display the magnitude of the current book in that TextView
        authorTextView.setText( formatAuthor(currentBook.getAuthors()));

        // Find the TextView with view ID magnitude tv3 for setting description
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.book_description) ;
        // Display the magnitude of the current book in that TextView
        descriptionTextView.setText(currentBook.getBookDescription()) ;

        return listItemView ;
    }

    /* Method that formats the author string in a proper way.
       Since the JSON ARRAY response returns a string like [J.k.Rowling,Hermione Granger,Draco Malfoy];
       this method removes the brackets and formats the author string in a proper way.
     */
    private String formatAuthor (String authors){

        return authors.replace("[", "").replace("]", "").replace("\"","").replace(",",", ") ;
    }
}
