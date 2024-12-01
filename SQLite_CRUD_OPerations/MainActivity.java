package com.example.practice_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.database.Cursor;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    EditText eId, eName;
    Button bInsert, bUpdate, bDelete, bDisplay;
    Spinner spinn;
    ListView listView;

    String[] spinnItems = {"AI","DS","CC","ML"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eId = findViewById(R.id.eId);
        eName = findViewById(R.id.eName);
        spinn = findViewById(R.id.spinn);
        bInsert = findViewById(R.id.bInsert);
        bDelete = findViewById(R.id.bDelete);
        bUpdate = findViewById(R.id.bUpdate);
        bDisplay = findViewById(R.id.bDisplay);
        listView = findViewById(R.id.listView);

        ArrayList al = new ArrayList();

        DBHelper db = new DBHelper(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spinnItems);
        spinn.setAdapter(aa);

        bInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String id = eId.getText().toString();
                String name = eName.getText().toString();
                String topic = spinn.getSelectedItem().toString();

                if(id.isEmpty() || name.isEmpty() || topic.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.insertStudent(id, name, topic)){
                        Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.displayData();

                if(cursor != null && cursor.getCount() > 0) {
                    al.clear();
                    while (cursor.moveToNext()) {
                        String id = cursor.getString(0);
                        String name = cursor.getString(1);
                        String topic = cursor.getString(2);

                        al.add("Id: " + id + "\nName: " + name + "\nTopic: " + topic);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, al);
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "No data available !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = eId.getText().toString();
                String name = eName.getText().toString();
                String topic = spinn.getSelectedItem().toString();

                if(id.isEmpty() || name.isEmpty() || topic.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill all fields !", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.updateStudent(id, name, topic)) {
                        Toast.makeText(MainActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = eId.getText().toString();

                if(db.deleteStudent(id)){
                    Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
