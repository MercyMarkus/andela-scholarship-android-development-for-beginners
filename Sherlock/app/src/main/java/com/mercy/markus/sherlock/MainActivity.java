package com.mercy.markus.sherlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the View that holds the start button
        Button startButton = (Button) findViewById(R.id.start);

// Set a click listener on that View
        startButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the start Button View is clicked on.
            @Override
            public void onClick(View view) {
                // create a new intent to open the {@link QuizActivity}
                Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(quizIntent);

                Toast.makeText(view.getContext(),"When you have eliminated the impossible, " +
                        "whatever remains, however improbable, must be the truth", Toast.LENGTH_LONG).show();
            }
        });



    }
}
