package com.example.medicationreminder.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.medicationreminder.MainActivity;
import com.example.medicationreminder.R;
import com.example.medicationreminder.models.Medication;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Ambil data dari intent
        String medicationName = intent.getStringExtra("medication_name");
        String dose = intent.getStringExtra("dose");

        // Buat notifikasi
        sendNotification(context, medicationName, dose);
    }

    private void sendNotification(Context context, String medicationName, String dose) {
        // Buat intent untuk membuka MainActivity ketika notifikasi diklik
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Tentukan suara notifikasi
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Bangun notifikasi
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "medication_reminder_channel")
                .setSmallIcon(R.drawable.ic_medication) // Ikon notifikasi
                .setContentTitle("Time to take your medication!")
                .setContentText(medicationName + " - " + dose)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        // Kirim notifikasi
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Untuk Android Oreo dan lebih tinggi, Anda harus mendefinisikan channel notifikasi
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "medication_reminder_channel";
            NotificationChannel channel = new NotificationChannel(channelId, "Medication Reminders", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0, builder.build());
    }
}
