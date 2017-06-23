package com.example.android.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import static android.R.drawable.ic_dialog_alert;

/**
 * Created by atsnguyen on 6/19/2017.
 */

public class Bindservice extends Service {
    MyBinder binder = new MyBinder();
    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"Service created",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"Bindservice destroyed",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        final int NOTIF_CODE = 1;
        NotificationCompat.Builder compat = new NotificationCompat.Builder(getApplicationContext());
        compat.setAutoCancel(false);
        compat.setSmallIcon(ic_dialog_alert);
        compat.setContentTitle("Bind_service");
        compat.setContentText("Binded Service");
        // TO DO 4 Add code to send notification with code defined above
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(),"Unbind Bindservice",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    public void access(String data)
    {
        Toast.makeText(getApplicationContext(),"Bindservice: " + data,Toast.LENGTH_SHORT).show();
    }
    public class MyBinder extends Binder
    {
        Bindservice getService()
        {
            return Bindservice.this;
        }
    }
}
