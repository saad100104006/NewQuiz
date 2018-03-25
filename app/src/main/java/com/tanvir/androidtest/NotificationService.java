package com.tanvir.androidtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Saad on 3/24/18.
 */

public class NotificationService extends Service {



    public static int id;
    public static String msg;
    Notification.Builder builder;
    NotificationManager mNotificationManager;
    int notifyID = 1;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return Service.START_STICKY;

    }

    @Override
    public void onCreate() {
        // Check if notification should be shown and do so if needed


        mNotificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        builder = new Notification.Builder(getApplicationContext());
        builder.setContentTitle("Scheduled Notification");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.build();




        new CountDownTimer(360000, 1000) {

            public void onTick(long millisUntilFinished) {

                SimpleDateFormat formatter = new SimpleDateFormat("mm:ss", Locale.UK);

                Date date = new Date(millisUntilFinished);
                String result = formatter.format(date);

                msg=String.valueOf("time remaining: " +result);
                builder.setContentText(msg);

                mNotificationManager.notify(
                        notifyID,
                        builder.build());


                startForeground(notifyID,  builder.build());

            }

            public void onFinish() {


            }
        }.start();


    }

}




