package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class New extends Activity {
    TextView tv1;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = findViewById(R.id.tv1);
        back = findViewById(R.id.back);

        Intent intent = getIntent();


        String pow = intent.getStringExtra("pow");
        String avg = intent.getStringExtra("avg");

        if(intent.hasExtra("pow"))
        {
            tv1.setText("Factorial = " + pow);
        } else if (intent.hasExtra("avg")) {
            tv1.setText("Sum of Digits = " + avg);
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(New.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
