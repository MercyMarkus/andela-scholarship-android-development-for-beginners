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

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        final ArrayList<Destination> destination = new ArrayList<>();
        Location stadium = new Location("Ahmadu Bello Stadium");
        stadium.setLatitude(0);
        stadium.setLongitude(0);
        destination.add(new Destination("Barcode Lounge", "+234 803 277 2282", "Plot B4 Uganda Street, Barnawa, Kaduna", R.drawable.studiomic,stadium));
        destination.add(new Destination("House 50 Lounge", "+234 806 598 2117", "50, Nyerere Road, HighCost", R.drawable.saxophone,stadium));
        destination.add(new Destination("NAF Club", "+234 802 871 5947", "16 Rabah Road, Kaduna North", R.drawable.airplane,stadium));
        destination.add(new Destination("The Castle Lounge", "+234 816 767 6744", "No. 2, Garba Abbas Street, Barnawa G.R.A", R.drawable.castle, stadium));
        destination.add(new Destination("Empire Ultra Lounge", "+234 0705 601 9687", "19/20 Mozambique Road, Opposite Jinie School, Barnawa", R.drawable.guitar, stadium));

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
