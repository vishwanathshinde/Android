package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class New extends Activity {
    TextView tv3, tv4, tv6, tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(New.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day_of_month) {
                        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
                        tv3.setText(currentDateString);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(New.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day_of_month) {
                        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
                        tv4.setText(currentDateString);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(New.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourr, int minn) {
                        tv6.setText(hourr + " : " + minn);
                    }
                },hour,min,false);
                timePickerDialog.show();
            }
        });

        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(New.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourr, int minn) {
                        tv7.setText(hourr + " : " + minn);
                    }
                },hour,min,false);
                timePickerDialog.show();
            }
        });


    }
}