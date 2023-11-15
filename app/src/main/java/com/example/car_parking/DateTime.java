package com.example.car_parking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class DateTime extends AppCompatActivity {

    private DatePicker datePicker;
    private TimePicker timePickerFrom;
    private TimePicker timePickerTo;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        String p= getIntent().getStringExtra("SELECTED_LOCATION");
        String email = getIntent().getStringExtra("email");

        datePicker = findViewById(R.id.datePicker);
        timePickerFrom = findViewById(R.id.timePickerFrom);
        timePickerTo = findViewById(R.id.timePickerTo);
        btnNext = findViewById(R.id.btnNext);

        // Set date picker to allow selecting a date within 5 days starting from today
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        datePicker.setMaxDate(calendar.getTimeInMillis());
        calendar = Calendar.getInstance();
        datePicker.setMinDate(calendar.getTimeInMillis());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Get the selected date and time values
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int day = datePicker.getDayOfMonth();
                    int hourFrom = timePickerFrom.getHour();
                    int minuteFrom = timePickerFrom.getMinute();
                    int hourTo = timePickerTo.getHour();
                    int minuteTo = timePickerTo.getMinute();

                    // You can pass these values to the next activity or perform further actions here
                    Intent intent = new Intent(DateTime.this, Slot.class);
                    intent.putExtra("SELECTED_LOCATION", p);
                    intent.putExtra("email",email);
                    intent.putExtra("selectedYear", year);
                    intent.putExtra("selectedMonth", month);
                    intent.putExtra("selectedDay", day);
                    intent.putExtra("selectedHourFrom", hourFrom);
                    intent.putExtra("selectedMinuteFrom", minuteFrom);
                    intent.putExtra("selectedHourTo", hourTo);
                    intent.putExtra("selectedMinuteTo", minuteTo);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInput() {
        // Get the current date and time
        Calendar currentCalendar = Calendar.getInstance();
        Date currentDate = currentCalendar.getTime();

        // Get the selected date and time
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        int hourFrom = timePickerFrom.getHour();
        int minuteFrom = timePickerFrom.getMinute();
        int hourTo = timePickerTo.getHour();
        int minuteTo = timePickerTo.getMinute();

        Calendar selectedCalendar = Calendar.getInstance();
        selectedCalendar.set(year, month, day, hourFrom, minuteFrom);

        if (selectedCalendar.getTime().before(currentDate) && year == currentCalendar.get(Calendar.YEAR) && month == currentCalendar.get(Calendar.MONTH) && day == currentCalendar.get(Calendar.DAY_OF_MONTH) && hourFrom <= currentCalendar.get(Calendar.HOUR_OF_DAY)) {
            Toast.makeText(this, "From time must be greater than current time if the date is today.", Toast.LENGTH_SHORT).show();
            return false;
        }
        

        if (hourFrom > hourTo || (hourFrom == hourTo && minuteFrom >= minuteTo)) {
            Toast.makeText(this, "From time should be less than To time.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
