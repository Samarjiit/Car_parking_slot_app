package com.example.car_parking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.car_parking.DatabaseHelper;
import com.example.car_parking.R;
import com.example.car_parking.SlotItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slot extends AppCompatActivity {

    public Button[] buttons;
    public int selectedSlotNumber = -1;
    public String name1;
    public SlotItem st = new SlotItem();
    public boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);

        buttons = new Button[11];
        buttons[1] = (Button) findViewById(R.id.btn1);
        buttons[2] = (Button) findViewById(R.id.btn2);
        buttons[3] = (Button) findViewById(R.id.btn3);
        buttons[4] = (Button) findViewById(R.id.btn4);
        buttons[5] = (Button) findViewById(R.id.btn5);
        buttons[6] = (Button) findViewById(R.id.btn6);
        buttons[7] = (Button) findViewById(R.id.btn7);
        buttons[8] = (Button) findViewById(R.id.btn8);
        buttons[9] = (Button) findViewById(R.id.btn9);
        buttons[10] = (Button) findViewById(R.id.btn10);
        Button cont=(Button)findViewById(R.id.btnc);

        @SuppressLint("MissingInflatedId") TextView t=(TextView)findViewById(R.id.t1);

        Intent intent = getIntent();
        String selectedLocation = intent.getStringExtra("SELECTED_LOCATION");
        int selectedYear = intent.getIntExtra("selectedYear", 0);
        int selectedMonth = intent.getIntExtra("selectedMonth", 0);
        int selectedDay = intent.getIntExtra("selectedDay", 0);
        int selectedHourFrom = intent.getIntExtra("selectedHourFrom", 0);
        int selectedMinuteFrom = intent.getIntExtra("selectedMinuteFrom", 0);
        int selectedHourTo = intent.getIntExtra("selectedHourTo", 0);
        int selectedMinuteTo = intent.getIntExtra("selectedMinuteTo", 0);
        String email=intent.getStringExtra("email");

        String date = String.format("%04d-%02d-%02d", selectedYear, selectedMonth, selectedDay);
        String fromTime = String.format("%02d:%02d", selectedHourFrom, selectedMinuteFrom);
        String toTime = String.format("%02d:%02d", selectedHourTo, selectedMinuteTo);


        DatabaseHelper dh = new DatabaseHelper(Slot.this);
        st = dh.checkSlotAvailability(date, fromTime, toTime, selectedLocation);

        setButtonBackgroundBasedOnAvailability(st, 1);
        setButtonBackgroundBasedOnAvailability(st, 2);
        setButtonBackgroundBasedOnAvailability(st, 3);
        setButtonBackgroundBasedOnAvailability(st, 4);
        setButtonBackgroundBasedOnAvailability(st, 5);
        setButtonBackgroundBasedOnAvailability(st, 6);
        setButtonBackgroundBasedOnAvailability(st, 7);
        setButtonBackgroundBasedOnAvailability(st, 8);
        setButtonBackgroundBasedOnAvailability(st, 9);
        setButtonBackgroundBasedOnAvailability(st, 10);

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot1)
                    return;
                name1 = "slot1";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(1);
                setOtherSlotsBackgroundBasedOnAvailability(st, 1);
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot2)
                    return;
                name1 = "slot2";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(2);
                setOtherSlotsBackgroundBasedOnAvailability(st, 2);
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot3)
                    return;
                name1 = "slot3";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(3);
                setOtherSlotsBackgroundBasedOnAvailability(st, 3);
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot4)
                    return;
                name1 = "slot4";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(4);
                setOtherSlotsBackgroundBasedOnAvailability(st, 4);
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot5)
                    return;
                name1 = "slot5";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(5);
                setOtherSlotsBackgroundBasedOnAvailability(st, 5);
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot6)
                    return;
                name1 = "slot6";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(6);
                setOtherSlotsBackgroundBasedOnAvailability(st, 6);
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot7)
                    return;
                name1 = "slot7";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(7);
                setOtherSlotsBackgroundBasedOnAvailability(st, 7);
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot8)
                    return;
                name1 = "slot8";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(8);
                setOtherSlotsBackgroundBasedOnAvailability(st, 8);
            }
        });
        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot9)
                    return;
                name1 = "slot9";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(9);
                setOtherSlotsBackgroundBasedOnAvailability(st, 9);
            }
        });
        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!st.slot10)
                    return;
                name1 = "slot10";
                flag=true;
                t.setText(name1);
                setSelectedSlotBackground(10);
                setOtherSlotsBackgroundBasedOnAvailability(st, 10);
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    Toast.makeText(Slot.this,"Please select Your Slot",Toast.LENGTH_SHORT);
                    return;
                }
                // Calculate the duration in minutes
                int selectedSlotDuration = calculateDuration(fromTime, toTime);
                // Calculate the price (2 rupees per minute)
                int price = selectedSlotDuration * 2;
                Intent intent = new Intent(Slot.this, PaymentDetails.class);
                intent.putExtra("SELECTED_LOCATION", selectedLocation);
                intent.putExtra("email",email);
                intent.putExtra("date", date);
                intent.putExtra("fromtime", fromTime);
                intent.putExtra("totime", toTime);
                intent.putExtra("slot", name1);
                intent.putExtra("price", price);
                startActivity(intent);
            }
        });

// Helper method to calculate the duration in minutes

        // Add similar onClickListeners for buttons[2] to buttons[10]
    }

    // Helper method to set button background color based on availability
    private void setButtonBackgroundBasedOnAvailability(SlotItem st, int slotNumber) {
        Button button = buttons[slotNumber];
        button.setClickable(true);
        if (st.isSlotAvailable(slotNumber)) {
            button.setBackgroundColor(Color.GREEN);
        } else {
            button.setClickable(false);
            button.setBackgroundColor(Color.RED);
        }
    }

    // Helper method to set the background of the selected slot to blue
    private void setSelectedSlotBackground(int slotNumber) {
        for (int i = 1; i <= 10; i++) {
            if (i == slotNumber) {
                buttons[i].setBackgroundColor(Color.BLUE);
            }
        }
    }

    // Helper method to set all other slots to green if available (not red)
    private void setOtherSlotsBackgroundBasedOnAvailability(SlotItem st, int selectedSlotNumber) {
        for (int i = 1; i <= 10; i++) {
            if (i != selectedSlotNumber && st.isSlotAvailable(i)) {
                buttons[i].setBackgroundColor(Color.GREEN);
            }
        }
    }
    private int calculateDuration(String fromTime, String toTime) {
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date fromDate = timeFormat.parse(fromTime);
            Date toDate = timeFormat.parse(toTime);

            long durationMillis = toDate.getTime() - fromDate.getTime();
            int durationMinutes = (int) (durationMillis / (60 * 1000)); // Convert to minutes

            return durationMinutes;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // Handle the parsing error, return an appropriate value
        }
    }

}
