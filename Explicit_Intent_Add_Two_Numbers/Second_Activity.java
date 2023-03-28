package com.example.explicit_addtwono;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends Activity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1 = findViewById(R.id.tv1);
        int ans = getIntent().getIntExtra("result", 0);
        tv1.setText(Integer.toString(ans));
    }
}
