package com.ugurtansal.traning_advanced_level

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.ugurtansal.traning_advanced_level.ui.theme.Traning_advanced_levelTheme
import android.Manifest
import java.util.concurrent.TimeUnit
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ugurtansal.traning_advanced_level.work_manager.MyWorker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Traning_advanced_levelTheme {
                Page()
            }
        }
    }
}

@Composable
fun Page() {
    val context = LocalContext.current

    // Android 13+ için izin isteme mekanizması
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            createNotification(context)
        }
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            // İzin kontrolü (Android 13 ve sonrası için)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    createNotification(context)
                } else {
                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            } else {
                createNotification(context)
            }
        }) {
            Text("Notification Gönder")
        }

        Button(onClick = {
            val request = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(context).enqueue(request)
        }) {
            Text("DO")
        }
    }
}

fun createNotification(context: Context) {
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