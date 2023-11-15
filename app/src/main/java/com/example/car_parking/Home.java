package com.example.car_parking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.t1);
        DatabaseHelper dh=new DatabaseHelper(Home.this);
        // Get the email sent from MainActivity3
        String email = getIntent().getStringExtra("email");

        // Fetch user information based on the email from your database
        String userInfo = dh.getUserInfoByEmail(email);

        // Display the user information in the TextView
        textView.setText(userInfo);
    }

    // Method to fetch user information based on the email from your database

}
