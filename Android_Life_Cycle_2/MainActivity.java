package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("lifecycle2","onCreate() executed");

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, New.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle2","onStart() executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle2","onResume() executed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle2","onPause() executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle2","onStop() executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle2","onRestart() executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle2","onDestroy() executed");
    }
}