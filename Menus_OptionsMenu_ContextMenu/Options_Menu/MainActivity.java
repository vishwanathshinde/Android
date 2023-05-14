package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    TextView tv1;

    private static final int PICK_FROM_GALLERY = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        tv1 = findViewById(R.id.tv1);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"Find_Factorial");
        menu.add(1,2,2,"Sum_Of_Digits");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Find_Factorial":
                int num = Integer.parseInt(ed1.getText().toString());

                long fact = 1;

                for (int i = num; i>0; i--)
                {
                    fact = fact * i;
                }

                String s = String.valueOf(fact);
                tv1.setText("Factorial : " + s);
                break;

            case "Sum_Of_Digits":
                int no = Integer.parseInt(ed1.getText().toString());

                double sum = 0.0;
                double digit = 0.0;

                while(no != 0)
                {
                    digit = no % 10;
                    sum = sum + digit;
                    no = no / 10;
                }

                String f = String.valueOf(sum);
                tv1.setText("Factorial : " + f);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}