package com.ugurtansal.traning_advanced_level.work_manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ugurtansal.traning_advanced_level.R

class MyWorkerNotification(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {


    //Arka planda yapılacak işlemler
    override fun doWork(): Result {
        createNotif(applicationContext)

        return Result.success()
    }
}


fun createNotif(context: Context) {
    val notifiAdmin = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val channelId = "my_channel_id" // Sabit bir ID kullan

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            "Genel Bildirimler",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Bu kanal bildirimler için kullanılır"
        }
        notifiAdmin.createNotificationChannel(channel)
    }

    // BURAYA DİKKAT: channelId parametresini builder'a geçmelisin!
    val builder = NotificationCompat.Builder(context, channelId)
        .setContentTitle("Merhaba!")
        .setContentText("Bu bir bildirim içeriğidir.")
        .setSmallIcon(R.drawable.anchor_icon) // İkonun olduğundan emin ol
        .setPriority(NotificationCompat.PRIORITY_HIGH) // Android 8 altı için
        .setAutoCancel(true)

    notifiAdmin.notify(1, builder.build())
}