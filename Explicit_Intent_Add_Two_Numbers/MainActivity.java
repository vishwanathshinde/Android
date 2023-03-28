package com.example.explicit_addtwono;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no1 = Integer.parseInt(ed1.getText().toString());
                int no2 = Integer.parseInt(ed2.getText().toString());
                int ans;
                ans = no1 + no2;

                Intent i = new Intent(getApplicationContext(), Second_Activity.class);
                i.putExtra("result",ans);

                startActivity(i);
            }
        });
    }
}