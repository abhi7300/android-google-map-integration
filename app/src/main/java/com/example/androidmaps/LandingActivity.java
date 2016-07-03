package com.example.androidmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener{

    Button b ;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        b = (Button) findViewById(R.id.go_to_map_activity);
        b.setOnClickListener(this);

        searchButton = (Button) findViewById(R.id.search_places_button);
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go_to_map_activity:
                startMapActivity();
                break;
            case R.id.search_places_button:
                Log.d("Landing Activity", "search places button clicked");
                startSearchLocationActivity();
                break;
        }
    }

    private void startSearchLocationActivity() {

        Intent searchLocationIntent = new Intent(LandingActivity.this, SearchLocationActivity.class);
        startActivity(searchLocationIntent);
        finish();
    }

    private void startMapActivity() {
        Intent mapIntent = new Intent(LandingActivity.this, MapsActivity.class);
        startActivity(mapIntent);
        finish();
    }
}
