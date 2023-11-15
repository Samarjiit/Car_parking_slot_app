package com.example.car_parking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Suc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suc);
        String email=getIntent().getStringExtra("email");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation2);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_transactions) {
                    // Handle the "Home" navigation
                    Intent cityPageIntent = new Intent(Suc.this, CityPage.class);
                    cityPageIntent.putExtra("email",email);
                    startActivity(cityPageIntent);
                    return true;
                } else if (itemId == R.id.navigation_profile) {
                    // Handle the "Profile" navigation
                    Intent profileIntent = new Intent(Suc.this, Profile.class);
                    profileIntent.putExtra("email",email);
                    startActivity(profileIntent);
                    return true;
                }
                return false;
            }
        });
    }
}