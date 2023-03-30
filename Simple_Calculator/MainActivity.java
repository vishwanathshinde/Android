package com.example.simple_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button one_btn , two_btn , three_btn, four_btn, five_btn, six_btn, seven_btn, eight_btn,
            nine_btn, dot_btn, zero_btn, clear_btn, plus_btn, minus_btn, multiply_btn, divide_btn,
            equal_button;
    TextView tv1;

    String process;

    float mValueOne, mValueTwo;

    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one_btn = findViewById(R.id.one_btn);
        two_btn = findViewById(R.id.two_btn);
        three_btn = findViewById(R.id.three_btn);
        three_btn = findViewById(R.id.three_btn);
        four_btn = findViewById(R.id.four_btn);
        four_btn = findViewById(R.id.four_btn);
        five_btn = findViewById(R.id.five_btn);
        six_btn = findViewById(R.id.six_btn);
        six_btn = findViewById(R.id.six_btn);
        seven_btn = findViewById(R.id.seven_btn);
        eight_btn = findViewById(R.id.eight_btn);
        nine_btn = findViewById(R.id.nine_btn);
        zero_btn = findViewById(R.id.zero_btn);
        dot_btn = findViewById(R.id.dot_btn);
        clear_btn = findViewById(R.id.clear_btn);
        plus_btn = findViewById(R.id.plus_btn);
        minus_btn = findViewById(R.id.minus_btn);
        multiply_btn = findViewById(R.id.multiply_btn);
        divide_btn = findViewById(R.id.divide_btn);
        equal_button = findViewById(R.id.equal_button);
        tv1 = findViewById(R.id.tv1);

        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "1");
            }
        });

        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "2");
            }
        });

        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "3");
            }
        });

        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "4");
            }
        });

        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "5");
            }
        });

        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "6");
            }
        });

        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "7");
            }
        });

        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "8");
            }
        });

        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + "9");
            }
        });

        dot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();
                tv1.setText(process + ".");
            }
        });

        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv1.getText().toString();  //chain calling method (method after method)
                tv1.setText(process + "0");
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
            }
        });

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv1 == null) {
                    tv1.setText("");
                } else {
                    mValueOne = Float.parseFloat(tv1.getText() + "");
                    crunchifyAddition = true;
                    tv1.setText(null);
                }
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(tv1.getText() + "");
                mSubtract = true;
                tv1.setText(null);
            }
        });

        multiply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(tv1.getText() + "");
                crunchifyMultiplication = true;
                tv1.setText(null);
            }
        });

        divide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(tv1.getText() + "");
                crunchifyDivision = true;
                tv1.setText(null);
            }
        });

        equal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(tv1.getText() + "");
                if (crunchifyAddition == true) {
                    tv1.setText(mValueOne + mValueTwo + "");
                    crunchifyAddition = false;
                }
                if (mSubtract == true) {
                    tv1.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }
                if (crunchifyMultiplication == true) {
                    tv1.setText(mValueOne * mValueTwo + "");
                    crunchifyMultiplication = false;
                }
                if (crunchifyDivision == true) {
                    tv1.setText(mValueOne / mValueTwo + "");
                    crunchifyDivision = false;
                }
            }
        });
    }
}