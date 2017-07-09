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

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        final ArrayList<Destination> destination = new ArrayList<>();
        Location stadium = new Location("Ahmadu Bello Stadium");
        stadium.setLatitude(0);
        stadium.setLongitude(0);
        destination.add(new Destination("Ahmadu Bello Stadium", "+234 818 569 6153", "City Centre, Off Stadium Roundabout", R.drawable.statium,stadium));
        destination.add(new Destination("Kaduna Golf Club", "+234 814 844 6492", "No. 1 Golf Course Road\n" +
                "9227 Ungwan Rimi", R.drawable.golf, stadium));
        destination.add(new Destination("Kaduna Township Stadium", "+234 806 269 6843", "Bida Road, Sabon Gari", R.drawable.football, stadium));
        destination.add(new Destination("Murtala Square", "+234 809 066 8276", "City Centre, Kaduna", R.drawable.sports, stadium));
        destination.add(new Destination("Body Magic Gym", "", "15 Kubani Crescent,barnawa", R.drawable.gym, stadium));
        destination.add(new Destination("Asaa Pyramids Pool", "+234 703 363 3573", "Lafia Road, City Centre", R.drawable.swimming, stadium));
        destination.add(new Destination("Kabir Gym & Spa", "", "12 Abdulrahman Okene Road", R.drawable.spa, stadium));

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
