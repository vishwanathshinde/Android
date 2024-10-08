package com.example.practice_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView1 = findViewById(R.id.listView1);

        String location = getIntent().getStringExtra("location");
        String area = getIntent().getStringExtra("area");
        String price = getIntent().getStringExtra("price");

        String[] propertyDetails = {"Location: " + location, "Area: " + area + " sqft", "Price: " + price};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, propertyDetails);
        listView1.setAdapter(adapter);
    }
}
