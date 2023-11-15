package com.example.car_parking;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;


import android.widget.Toast;

public class Place extends Activity {
    String selectedPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        String email = getIntent().getStringExtra("email");
        Intent intent = getIntent();
        String selectedLocation = intent.getStringExtra("SELECTED_LOCATION");
        Button b = findViewById(R.id.count);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Place.this, DateTime.class);
                intent.putExtra("SELECTED_LOCATION", selectedPlace);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        // Depending on the location, set up the category cards with the appropriate places
        if (selectedLocation != null) {
            if (selectedLocation.equals("Udupi")) {
                setupCategoryCard("College", R.id.cardViewCollege, new String[]{"MIT", "PPC", "MGM", "NITE", "MAHE"});
                setupCategoryCard("Mall", R.id.cardViewMall, new String[]{"Canara Mall", "City Center", "Time Square"});
                setupCategoryCard("Theatre", R.id.cardViewTheatre, new String[]{"Bharat Cinemas", "Inox"});
                setupCategoryCard("Tourist Places", R.id.cardViewTourist, new String[]{"Malpe", "Museum"});
            } else if (selectedLocation.equals("Bengaluru")) {
                setupCategoryCard("College", R.id.cardViewCollege, new String[]{"christ college", "PES", "RV"});
                setupCategoryCard("Mall", R.id.cardViewMall, new String[]{"UB City Mall", "Orion Center", "Garuda Mall"});
                setupCategoryCard("Theatre", R.id.cardViewTheatre, new String[]{"Urvashi Cinemas", "Veeresh", "Srinivas Theatre"});
                setupCategoryCard("Tourist Places", R.id.cardViewTourist, new String[]{"Botanical Garden", "Wonderla"});
            }
        }
    }

    private void setupCategoryCard(final String category, int cardViewId, final String[] places) {
        // Initialize a new PopupWindow for each category
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_menu_item, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        // Set the background color of the PopupWindow to make it bright
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE)); // Adjust the color as needed

        // Get reference to the ListView for displaying the place list
        final ListView placeListView = popupView.findViewById(R.id.place_list);

        // Set a simple ArrayAdapter to display the list of places
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, places);
        placeListView.setAdapter(adapter);

        // Set item click listener for the ListView
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected place and do something with it (e.g., show a Toast)
                selectedPlace = places[position];
                Toast.makeText(Place.this, "Selected Place: " + selectedPlace, Toast.LENGTH_SHORT).show();

                // Dismiss the popup menu
                popupWindow.dismiss();
            }
        });

        // Set click listener for the Category Card
        final View categoryCard = findViewById(cardViewId);
        categoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the popup menu at the center of the screen
                popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.CENTER, 0, 0);

                // Dim the background by adding a semi-transparent overlay
                View dimBackground = findViewById(R.id.dim_background);
                dimBackground.setVisibility(View.VISIBLE);
            }
        });
    }
}