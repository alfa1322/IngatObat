package com.example.medicationreminder.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.example.medicationreminder.R;
import com.example.medicationreminder.activities.NotificationDetailActivity;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String medicationName = intent.getStringExtra("medication_name");

        // Create a notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "medication_channel")
                .setSmallIcon(R.drawable.ic_medication)
                .setContentTitle("Time to take your medication")
                .setContentText(medicationName)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        Intent notificationIntent = new Intent(context, NotificationDetailActivity.class);
        notificationIntent.putExtra("medication_name", medicationName);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}
