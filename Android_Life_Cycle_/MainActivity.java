package com.example.android_life_cycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    String tag = "Activity Life Cycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate() method called!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(tag, "onStart() method called!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(tag, "onResume() method called!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(tag, "onPause() method called!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(tag, "onStop() method called!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(tag, "onDestroy() method called!");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(tag, "onRestart() method called!");
    }
}