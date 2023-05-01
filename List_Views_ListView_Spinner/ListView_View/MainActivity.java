package com.example.voicewithoutdialogbox;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] colors = {"Violet","Indigo","Green","Blue","Orange","Yellow","Red","Violet","Indigo",
                        "Green","Blue","Orange","Yellow","Red","Violet","Indigo","Green","Blue","Orange","Yellow","Red"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter newArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,colors);
        setListAdapter(newArrayAdapter);
    }

    public void onListItemClick(ListView parent, View view, int position, long id) {
        Toast.makeText(this, "You selected" + colors[position], Toast.LENGTH_SHORT).show();
    }
}