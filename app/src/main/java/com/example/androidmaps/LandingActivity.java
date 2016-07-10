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
    Button placeNameAutocompleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        b = (Button) findViewById(R.id.go_to_map_activity);
        b.setOnClickListener(this);

        searchButton = (Button) findViewById(R.id.search_places_button);
        searchButton.setOnClickListener(this);

        placeNameAutocompleteButton = (Button) findViewById(R.id.places_autocomplete_button);
        placeNameAutocompleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.go_to_map_activity:
                Log.d("Landing Activity", "Map activity button clicked.");
                startMapActivity();
                break;
            case R.id.search_places_button:
                Log.d("Landing Activity", "search places button clicked.");
                startSearchLocationActivity();
                break;
            case R.id.places_autocomplete_button:
                Log.d("Landing Activity", "Autocomplete place name button clicked.");
                startMapsAutocompleteActivity();
                break;
            case R.id.search_business_by_name_button:
                break;
            case R.id.show_business_search_results_as_list:
                break;
            case R.id.show_business_details_button:
                break;
            case R.id.search_business_within_an_area_button:
                break;
            case R.id.add_business_place_button:
                break;


        }
    }

    private void startMapsAutocompleteActivity() {

        Intent autocompleteIntent = new Intent(this, MapsAutocompleteActivity.class);
        startActivity(autocompleteIntent);
        finish();
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
