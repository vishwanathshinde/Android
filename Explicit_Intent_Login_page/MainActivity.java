package com.example.explicit_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText ed1, ed2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.e1);
        ed2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String username = ed1.getText().toString();
                String pwd = ed2.getText().toString();

                if((username.equals("pqr")) && (pwd.equals("pqr")))
                {
                    Intent i = new Intent(getApplicationContext(),New.class);
                    i.putExtra("uname", username);
                    startActivity(i);
                }
            }
        });
    }
}