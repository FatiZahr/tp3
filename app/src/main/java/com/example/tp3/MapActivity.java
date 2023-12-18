package com.example.tp3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap = null;
    private double mLat = -33.87365;
    private double mLng = 151.20689;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mGoogleMap = googleMap;
        addMarker(new LatLng(33.996561, -4.991881));
        addMarker(new LatLng(31.646579, -8.020580));
        addMarker(new LatLng(34.248745, -6.583234));
        addMarker(new LatLng(35.172901, -3.862036));
    }

    private void addMarker(LatLng position) {
        if (mGoogleMap != null) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title("Marker")
                    .snippet("ENSA"));
        }
    }

    private void addDraggableMarker(LatLng position) {
        if (mGoogleMap != null) {
            mGoogleMap.addMarker(new MarkerOptions()
                    .position(position)
                    .draggable(true)
                    .title("Draggable Marker")
                    .snippet("Snippet"));
        }
    }





}
