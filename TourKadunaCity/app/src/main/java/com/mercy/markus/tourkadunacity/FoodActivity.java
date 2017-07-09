package com.mercy.markus.tourkadunacity;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        final ArrayList<Destination> destination = new ArrayList<>();
        Location stadium = new Location("Ahmadu Bello Stadium");
        stadium.setLatitude(0);
        stadium.setLongitude(0);
        destination.add(new Destination("Chicken Republic", "+234 812 832 8515", " Zaire – Uganda Road, Barnawa", R.drawable.chicken, stadium));
        destination.add(new Destination("Delight Chinese Restaurant", "+234 803 506 2023", "A3, Mogadishu Layout, Off Ahmadu Bello Way", R.drawable.chinese, stadium));
        destination.add(new Destination("Pizzaland ", "+234 809 550 0911", " A 235, Kakuri", R.drawable.pizza, stadium));
        destination.add(new Destination("Eleven12 Ice Cream", "+234 818 131 8233", "Shop 5, Video Mars Shopping Complex, Isa Kaita Road", R.drawable.icecreamcup, stadium));
        destination.add(new Destination("Phillycious Cakes", "+234 903 215 9547", "Boumediene Rd, Narayi High Cost", R.drawable.cake, stadium));
        destination.add(new Destination("Fresh Fruit Bar", "+234 813 802 6936" , "Mayere Road, Narayi highCost before Viviana garden,Opp camp david", R.drawable.redcup, stadium));
        destination.add(new Destination("Habil's Cafe", "", "35 Muhammadu Buhari Way, City Centre", R.drawable.coffee, stadium));

        DestinationAdapter adapter = new DestinationAdapter(this, destination);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = destination.get(position).getDestinationLocation().getLatitude();
                Log.d("lat", ""+lat);
                double lon = destination.get(position).getDestinationLocation().getLongitude();
                Log.d("lon", ""+lon);
                String keyword = destination.get(position).getDestinationName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

    }

}
