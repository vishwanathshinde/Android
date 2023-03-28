package com.example.implicit_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Web Browser Button
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });

        // Make Call Button
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919370816113"));
                startActivity(i);
            }
        });

        // Google Map Button
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:51.5079, -0.0877"));
                startActivity(i);
            }
        });
    }
}