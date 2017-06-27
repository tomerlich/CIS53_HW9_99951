package com.example.android.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Bindservice bindservice1;
    Bindservice.MyBinder binder;
    ServiceConnection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO 1 Add code to start service
                Intent startServiceIntent = new Intent(getApplicationContext(), Startservice.class);
                startService(startServiceIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO 2 Add code to bind service
                Intent bindServiceIntent = new Intent(getApplicationContext(), Bindservice.class);
                Intent startServiceIntent = new Intent(getApplicationContext(), Startservice.class);
                bindService(bindServiceIntent, connection, Context.BIND_AUTO_CREATE);
                startService(startServiceIntent);
            }
        });
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // TO DO 3 Add code
                // - Get the service object from the binder object
                // - Call the "access" method in Bindservice with the string "Service connected"
                String data = "Service connected";
                binder.getService().access(data);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }
}
