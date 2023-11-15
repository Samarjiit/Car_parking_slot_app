package com.example.car_parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.time.format.TextStyle;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView t1,t2;
        t1=(TextView) findViewById(R.id.textView4);
        t2=(TextView) findViewById(R.id.textView5);
        String p= getIntent().getStringExtra("SELECTED_LOCATION");
        String email = getIntent().getStringExtra("email");
        t1.setText(p);
        t2.setText(email);
    }
}