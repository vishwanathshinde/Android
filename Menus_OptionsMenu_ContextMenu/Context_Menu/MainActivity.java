package com.example.voicewithoutdialogbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        b1 = findViewById(R.id.b1);

        registerForContextMenu(b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Long Press Me !", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Operation");
        //add menu items
        menu.add(1,1,1,"Find Factorial");
        menu.add(1,2,2,"Find Sum Of Digits");
    }

    // menu item select listener
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == "Find Factorial")
        {
            int num = Integer.parseInt(ed1.getText().toString());

            long fact = 1;

            for (int i = num; i>0; i--)
            {
                fact = fact * i;
            }

            String s = String.valueOf(fact);
            Intent intent = new Intent(MainActivity.this, New.class);
            intent.putExtra("pow",s);
            startActivity(intent);
        }
        else if (item.getTitle() == "Find Sum Of Digits")
        {
            int num = Integer.parseInt(ed1.getText().toString());

            double sum = 0.0;
            double digit = 0.0;

            while(num != 0)
            {
                digit = num % 10;
                sum = sum + digit;
                num = num / 10;
            }

            String f = String.valueOf(sum);

            Intent intent = new Intent(MainActivity.this, New.class);
            intent.putExtra("avg",f);
            startActivity(intent);
        }


        return true;
    }
}