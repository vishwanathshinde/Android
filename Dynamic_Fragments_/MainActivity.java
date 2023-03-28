package com.example.dynamic_fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        if(width > height)
        {
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(android.R.id.content,fragment1);
        }
        else
        {
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(android.R.id.content,fragment2);
        }
        fragmentTransaction.commit();
    }
}