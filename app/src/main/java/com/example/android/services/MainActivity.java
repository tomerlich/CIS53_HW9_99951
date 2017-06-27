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
import android.widget.Toast;


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
        Button button3 = (Button)findViewById(R.id.button3);            //Stop Service
        Button button4 = (Button)findViewById(R.id.button4);            //Unbind Service
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO 1 Add code to start service
                Intent Intent = new Intent(getApplicationContext(), Startservice.class);
                startService(Intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TO DO 2 Add code to bind service
                Intent Intent = new Intent(getApplicationContext(), Bindservice.class);
                bindService(Intent, connection, Context.BIND_AUTO_CREATE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stop service button
                Intent Intent = new Intent(getApplicationContext(), Startservice.class);
                stopService(Intent);
                Toast.makeText(
                        getApplicationContext(),
                        "Startservice is stopped",
                        Toast.LENGTH_SHORT).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //unbind service button
                unbindService(connection);
            }
        });
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                // TO DO 3 Add code
                // - Get the service object from the binder object
                // - Call the "access" method in Bindservice with the string "Service connected"
                String data = "Service connected";
                binder = ((Bindservice.MyBinder) service);
                bindservice1 = binder.getService();
                bindservice1.access(data);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

    }
}
