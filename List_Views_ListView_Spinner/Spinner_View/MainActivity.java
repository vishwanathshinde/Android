package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinner1;
    String[] colors = {"Violet","Indigo","Green","Blue","Orange","Yellow","Red","Violet","Indigo",
                        "Green","Blue","Orange","Yellow","Red","Violet","Indigo","Green","Blue","Orange","Yellow","Red"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter newArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,colors);

        spinner1.setAdapter(newArrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), colors[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}