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

public class Night_LifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        final ArrayList<Destination> destination = new ArrayList<>();
        Location stadium = new Location("Ahmadu Bello Stadium");
        stadium.setLatitude(0);
        stadium.setLongitude(0);
        destination.add(new Destination("11:45 club", "+234 909 596 7427", "3 Stephen Shekari close, Barnawa", R.drawable.beer, stadium));
        destination.add(new Destination("Legit Lounge", "+234 701 102 4545", "Mayere Rd, Barnawa", R.drawable.wineglass, stadium));
        destination.add(new Destination("Target Lounge", "", "Kufena Road, Kaduna North", R.drawable.target, stadium));
        destination.add(new Destination("Lush sport cafe & grill", "+234 806 878 5439", "Gwari Avenue, Barnawa ", R.drawable.redcup, stadium));
        destination.add(new Destination("Vault Lounge", "", "No 1, Algeria Crescent, Barnawa ", R.drawable.dancing, stadium));

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
