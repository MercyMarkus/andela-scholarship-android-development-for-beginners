package com.mercy.markus.tourkadunacity;

/**
 * Created by mesy on 06/07/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * {@link DestinationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Destination} objects.
 */
public class DestinationAdapter extends ArrayAdapter<Destination>  {

    /**
     * Create a new {@link DestinationAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param destination is the list of {@link Destination}s to be displayed.
     */
    public DestinationAdapter(Context context, ArrayList<Destination> destination) {
        super(context, 0, destination);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Destination currentDestination = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID destinationName.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.destinationName);
        // Get the name of Destination from the currentDestination object and set this text on
        // the nameTextView.
        nameTextView.setText(currentDestination.getDestinationName());

        // Find the TextView in the list_item.xml layout with the ID destinationNumber.
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.destinationNumber);
        // Get the number of the Destination from the currentDestination object and set this text on
        // the default TextView.
       numberTextView.setText(currentDestination.getDestinationNumber());

        //Find the TextView in the list_item.xml layout with the ID destinationAddress.
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.destinationAddress);
        //Get the address of the Destination from the currentDestination object and set the text on
        // the default TextView.
        addressTextView.setText(currentDestination.getDestinationAddress());

        // Find the TextView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Get the image of the destination from the currentDestination object and set the image on the
        // default ImageView
        imageView.setImageResource(currentDestination.getImageResourceId());


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
