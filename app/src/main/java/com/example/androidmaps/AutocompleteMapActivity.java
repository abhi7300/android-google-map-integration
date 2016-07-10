package com.example.androidmaps;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class AutocompleteMapActivity extends FragmentActivity implements OnMapReadyCallback, PlaceSelectionListener {

    private static final String TAG = "AutocompleteActivity" ;
    private GoogleMap gMap;
    private int DEFAULT_ZOOM_MAP = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete_map);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.autocomplete_result_map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng barrackpore = new LatLng(22.7604, 88.3579);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barrackpore, DEFAULT_ZOOM_MAP));
    }

    @Override
    public void onPlaceSelected(Place place) {
        // TODO: Get info about the selected place.
        Log.i(TAG, "Place: " + place.getName());
        Toast.makeText(this,  "Place: " + place.getName(), Toast.LENGTH_LONG);
        goToLocation(place);
    }

    @Override
    public void onError(Status status) {
// TODO: Handle the error.
        Log.i(TAG, "An error occurred: " + status);
        Toast.makeText(this, "An error occurred: " + status, Toast.LENGTH_LONG);
    }

    private void goToLocation(Place place){
        hideSoftKeyboard(findViewById(R.id.place_autocomplete_fragment));
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(place.getLatLng(),DEFAULT_ZOOM_MAP);
        gMap.moveCamera(update);

    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

}
