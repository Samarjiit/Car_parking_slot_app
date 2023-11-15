package com.example.car_parking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CityPage extends AppCompatActivity {
    private View dimBackground;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_page);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Retrieve the email from the Intent
        email = getIntent().getStringExtra("email");
        dimBackground = findViewById(R.id.dim_background);

        // Add click listeners for the CardViews
        View cardViewBeng = findViewById(R.id.cardViewBeng);
        View cardViewUdupi = findViewById(R.id.cardViewUdupi);
        View cardViewMang = findViewById(R.id.cardViewMang);
        View cardViewMys = findViewById(R.id.cardViewMys);

        cardViewBeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CityPage.this, "bengaluru", Toast.LENGTH_SHORT).show();
                startSecondActivity("Bengaluru");
            }
        });

        cardViewUdupi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity("Udupi");
            }
        });

        cardViewMang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity("Mangaluru");
            }
        });

        cardViewMys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity("Mysore");
            }
        });


        // Set click listener to dismiss the popup on overlay click
        dimBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dimBackground.setVisibility(View.GONE);
            }
        });

        // Set up the BottomNavigationView item selection here
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_transactions) {
                    return true;
                    // Handle the "Home" navigation
                    /*Intent cityPageIntent = new Intent(CityPage.this, CityPage.class);
                    cityPageIntent.putExtra("email",email);
                    startActivity(cityPageIntent);
                    return true;*/
                } else if (itemId == R.id.navigation_profile) {
                    // Handle the "Profile" navigation
                    Intent profileIntent = new Intent(CityPage.this, Profile.class);
                    profileIntent.putExtra("email",email);
                    startActivity(profileIntent);
                    return true;
                }
                return false;
            }
        });
    }

    private void startSecondActivity(String selectedLocation) {
        try {
            Intent intent = new Intent(CityPage.this, Place.class);
            intent.putExtra("SELECTED_LOCATION", selectedLocation);
            intent.putExtra("email", email);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
