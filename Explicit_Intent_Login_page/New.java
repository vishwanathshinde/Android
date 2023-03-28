package com.example.explicit_intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class New extends Activity {
    TextView tv1;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1 = findViewById(R.id.t1);
        String ans = getIntent().getStringExtra("uname");
        tv1.setText("Welcome " + ans);
    }
}