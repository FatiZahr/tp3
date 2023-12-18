package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    DrawerLayout drawerLayout;
    NavigationView navigationview;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar; // Add this line

    //Google Maps declarations
    private GoogleMap mGoogleMap=null;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout=findViewById(R.id.drawer_layout);
        navigationview=findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar); // Initialize the toolbar
        setSupportActionBar(toolbar); // Set the toolbar as the support action bar
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize the map asynchronously
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
       // mapFragment.getMapAsync(this);

        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.home) {
                    Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.calculator) {
                    Toast.makeText(MainActivity.this, "Calculator selected", Toast.LENGTH_SHORT).show();
                    Intent calculatorIntent = new Intent(MainActivity.this, CalculatorActivity.class);

                    // Start the activity
                    startActivity(calculatorIntent);
                } else if (itemId == R.id.dictionary) {
                    Toast.makeText(MainActivity.this, "Dictionary selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.chat) {
                    Toast.makeText(MainActivity.this, "Chat selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.login) {
                    Toast.makeText(MainActivity.this, "Login selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.profile) {
                    Toast.makeText(MainActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.logout) {
                    Toast.makeText(MainActivity.this, "Logout selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.share) {
                    Toast.makeText(MainActivity.this, "Share selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.rate_us) {
                    Toast.makeText(MainActivity.this, "Rate Us selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.map) {
                    Toast.makeText(MainActivity.this, "Map selected", Toast.LENGTH_SHORT).show();
                    // Create an Intent to start the MapActivity
                    Intent mapIntent = new Intent(MainActivity.this, MapActivity.class);

                    // Start the activity
                    startActivity(mapIntent);
                }

                // Close the drawer when an item is selected
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }

            });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mGoogleMap=googleMap;
    }
}