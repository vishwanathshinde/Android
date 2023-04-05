package com.example.insert_contact_using_intent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class New extends Activity {
    Button b1, b2;
    ImageButton call, contact, call2, message2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        call = findViewById(R.id.call);
        contact = findViewById(R.id.contact);
        call2 = findViewById(R.id.call2);
        message2 = findViewById(R.id.message2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Record Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Record Updated", Toast.LENGTH_SHORT).show();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Nako Dabu", Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Nako Dabu", Toast.LENGTH_SHORT).show();
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Make Call", Toast.LENGTH_SHORT).show();
            }
        });

        message2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(New.this, "Send Message", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

