package com.example.car_parking;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        Button btn = findViewById(R.id.btn);
        TextView t = findViewById(R.id.money);
        TextView intime = findViewById(R.id.intime);
        TextView outtime = findViewById(R.id.outtime);
        TextView name = findViewById(R.id.pname);
        @SuppressLint("MissingInflatedId") TextView date1=findViewById(R.id.date);
        TextView info=findViewById(R.id.infoTextView1);
        String n = name.getText().toString();
        String it = intime.getText().toString();
        String ou = outtime.getText().toString();
        String money = t.getText().toString();
        Intent intent = getIntent();
        String selectedLocation = intent.getStringExtra("SELECTED_LOCATION");
        String email = intent.getStringExtra("email");
        String date = intent.getStringExtra("date");
        String fromTime = intent.getStringExtra("fromtime");
        String toTime = intent.getStringExtra("totime");
        String slot = intent.getStringExtra("slot");
        int price = intent.getIntExtra("price", 0); // 0 is the default value if "price" is not provided
        t.setText(String.valueOf(price));
        intime.setText(fromTime);
        outtime.setText(toTime);
        name.setText(selectedLocation);
        date1.setText(date);
        info.setText(selectedLocation+" Parking");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentDetails.this, Card.class);
                intent.putExtra("SELECTED_LOCATION", selectedLocation);
                intent.putExtra("email",email);
                intent.putExtra("date", date);
                intent.putExtra("fromtime", fromTime);
                intent.putExtra("totime", toTime);
                intent.putExtra("slot", slot);
                intent.putExtra("price", price);
                startActivity(intent);

            }
        });
    }
}
