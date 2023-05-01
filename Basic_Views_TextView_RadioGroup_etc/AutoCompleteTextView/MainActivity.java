package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

    AutoCompleteTextView atv1;
    String[] names = { "Ajay", "Aniket", "Anirudh","Aaditi", "Aakshay" ,"Anishri","Anish","Ajdya","Aakash"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atv1 = findViewById(R.id.atv1);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        atv1.setThreshold(1);
        atv1.setAdapter(adapter);
    }
}