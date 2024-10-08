package com.example.practice_app;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText propLocation, propArea, propPrice;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propLocation = findViewById(R.id.propLocation);
        propArea = findViewById(R.id.propArea);
        propPrice = findViewById(R.id.propPrice);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String location = propLocation.getText().toString();
                String area = propArea.getText().toString();
                String price = propPrice.getText().toString();

                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                i.putExtra("location",location);
                i.putExtra("area",area);
                i.putExtra("price",price);

                startActivity(i);
            }
        });
    }
}