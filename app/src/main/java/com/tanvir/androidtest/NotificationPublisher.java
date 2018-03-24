package com.tanvir.androidtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;



/**
 * Created by Saad on 3/24/18.
 */

public class NotificationPublisher extends BroadcastReceiver {


    public static int id;
    int notifyID = 1;


    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, NotificationService.class);
        context.startService(i);


    }

}