package com.example.portrait_landscape_convert_interest_rates;

import static java.lang.Math.pow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    Button button;
    EditText editRate;
    TextView textResult;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editRate = findViewById(R.id.editRate);
        textResult = findViewById(R.id.textResult);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double inputRate = 0.0;
                double convertedRate = 0.0;

                try {
                    inputRate = Double.parseDouble(editRate.getText().toString())/100.0;
                } catch (Exception ex) {
                    editRate.setText("0.0");
                }

                if (((RadioButton)(findViewById(R.id.radioMonthly))).isChecked()) {
                    //If converting to monthly
                    convertedRate = (pow((1.0 + inputRate),(1.0/12.0)) - 1.0) * 100.0;
                } else {
                    // Converting to yearly
                    convertedRate = (pow((1.0 + inputRate), 12) - 1.0) * 100.0;
                }
                textResult.setText(String.format("Converted Rate is %1$.4f%%", convertedRate));
            }
        });
    }
}
