package com.example.voicewithoutdialogbox;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnOpen;
    ImageButton btnImg1;
    EditText txtName;
    CheckBox chkAutosave, star;
    RadioGroup rdbGp1;
    RadioButton rdb1, rdb2;
    ToggleButton toggle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnOpen = findViewById(R.id.btnOpen);
        btnImg1 = findViewById(R.id.btnImg1);
        txtName = findViewById(R.id.txtName);
        chkAutosave = findViewById(R.id.chkAutosave);
        star = findViewById(R.id.star);
        rdbGp1 = findViewById(R.id.rdbGp1);
        rdb1 = findViewById(R.id.rdb1);
        rdb2 = findViewById(R.id.rdb2);
        toggle1 = findViewById(R.id.toggle1);

        btnOpen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DisplayToast("You clicked Open Button");
           }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DisplayToast("You clicked Save Button");
           }
        });

        chkAutosave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkAutosave.isChecked())
                    DisplayToast("CheckBox is Checked");
                else
                    DisplayToast("CheckBox not Checked");
            }
        });

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(star.isChecked())
                    DisplayToast("CheckBox is Checked");
                else
                    DisplayToast("CheckBox not Checked");
            }
        });

        rdbGp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group , int checkedId) {
                if (rdb1.isChecked())
                    DisplayToast("Male Checked");
                else
                    DisplayToast("Female Checked");
            }
        });

        toggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle1.isChecked())
                    DisplayToast("Toggle button is on");
                else
                    DisplayToast("Toggle Button is off");
            }
        });

    }
    private void DisplayToast(String msg){
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
    }
}