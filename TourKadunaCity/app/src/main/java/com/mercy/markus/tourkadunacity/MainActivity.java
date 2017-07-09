package com.mercy.markus.tourkadunacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout artsCulture = (RelativeLayout) findViewById(R.id.arts_culture);
        artsCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artsCultureIntent = new Intent(MainActivity.this, Arts_CultureActivity.class);
                startActivity(artsCultureIntent);
            }
        });

        RelativeLayout food = (RelativeLayout) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodIntent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(foodIntent);
            }
        });

        RelativeLayout music = (RelativeLayout) findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        });

        RelativeLayout nightLife = (RelativeLayout) findViewById(R.id.night_life);
        nightLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nightLifeIntent = new Intent(MainActivity.this, Night_LifeActivity.class);
                startActivity(nightLifeIntent);
            }
        });

        RelativeLayout sports = (RelativeLayout) findViewById(R.id.sports);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sportsIntent = new Intent(MainActivity.this, SportsActivity.class);
                startActivity(sportsIntent);
            }
        });
    }
}
