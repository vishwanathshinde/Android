package com.example.practice_app;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    EditText eName, eDept, eSalary;
    Button submit, display, update, delete;
    ListView listViewData;

    @Override
    protected void onCreate(Bundle sIS){
        super.onCreate(sIS);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.eName);
        eDept = findViewById(R.id.eDept);
        eSalary = findViewById(R.id.eSalary);
        submit = findViewById(R.id.submit);
        display = findViewById(R.id.display);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        listViewData = findViewById(R.id.listViewData);

        DBHelper dbHelper = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = eName.getText().toString();
                String dept = eDept.getText().toString();
                String salary = eSalary.getText().toString();
                
                if(dbHelper.registerEmployee(name, dept, salary)){
                    Toast.makeText(MainActivity.this, "Record Inserted!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor res = dbHelper.getAllData();
                ArrayList<String> dataList = new ArrayList<>();

                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                    return;
                }
                while (res.moveToNext()) {
                    String id = res.getString(0);
                    String name = res.getString(1);
                    String dept = res.getString(2);
                    String salary = res.getString(3);
                    dataList.add("ID: " + id + "\nName: " + name + "\nDept: " + dept + "\nSalary: " + salary);
                }

                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dataList);
                listViewData.setAdapter(adapter);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eName.getText().toString();
                String dept = eDept.getText().toString();
                String salary = eSalary.getText().toString();

                if (dbHelper.updateEmployee(name, dept, salary)) {
                    Toast.makeText(MainActivity.this, "Record Updated!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eName.getText().toString(); // Get ID

                if (dbHelper.deleteEmployee(name)) {
                    Toast.makeText(MainActivity.this, "Record Deleted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}