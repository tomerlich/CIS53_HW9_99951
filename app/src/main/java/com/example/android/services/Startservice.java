package com.example.android.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import static android.R.drawable.ic_dialog_alert;

/**
 * Created by atsnguyen on 6/19/2017.
 */

public class Startservice extends Service {
    public static final int NOTIF_CODE = 2;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"Service created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationCompat.Builder compat = new NotificationCompat.Builder(getApplicationContext());
        compat.setAutoCancel(true);
        compat.setSmallIcon(ic_dialog_alert);
        compat.setContentTitle("Start_Service");
        compat.setContentText("Service Running");
        // TO DO 5 Add code to send notification using NOTIF_CODE defined above
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIF_CODE, compat.build());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int getNOTIF_CODE() {
        return NOTIF_CODE;
    }
}
