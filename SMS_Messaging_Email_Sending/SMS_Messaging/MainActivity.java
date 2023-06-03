package com.example.voicewithoutdialogbox;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    EditText tv1, tv2;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        call = findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
                }
                else
                {
                    String phno = tv1.getText().toString();
                    String message = tv2.getText().toString();

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phno, phno, message, null, null);
                    Toast.makeText(MainActivity.this, "Message Sent !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}