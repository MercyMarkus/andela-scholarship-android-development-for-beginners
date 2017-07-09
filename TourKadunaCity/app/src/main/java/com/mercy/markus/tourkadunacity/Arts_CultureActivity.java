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

public class Arts_CultureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        final ArrayList<Destination> destination = new ArrayList<>();
        Location stadium = new Location("Ahmadu Bello Stadium");
        stadium.setLatitude(0);
        stadium.setLongitude(0);
        destination.add(new Destination("Kaduna Museum", "+234 812 475 3894", "Kaduna City Centre", R.drawable.culture, stadium));
        destination.add(new Destination("Saulawa Arts Gallery", "+234 806 580 3335", "By Safaha Trade Centre Sultan Road, Kwata Road, Kaduna North", R.drawable.painting, stadium));
        destination.add(new Destination("Bayyours Art and Gallery", "+234 803 607 2702", "18, Sokoto Road, Kakuri", R.drawable.art, stadium));
        destination.add(new Destination("Rabah Gallery", "+234 809 111 1720", "Plot 10, Rabah Road", R.drawable.painting, stadium));
        destination.add(new Destination("Arabian Gallery", "+234 807 301 8174", "Mangal Plaza", R.drawable.arabian, stadium));

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
