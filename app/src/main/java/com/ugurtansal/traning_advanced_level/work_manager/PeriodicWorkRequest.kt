package com.ugurtansal.traning_advanced_level.work_manager


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ugurtansal.traning_advanced_level.ui.theme.Traning_advanced_levelTheme
import java.util.concurrent.TimeUnit
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager

class MainPeriodic : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Traning_advanced_levelTheme {
                PeriodaicPage()
            }
        }
    }
}

@Composable
fun PeriodaicPage() {
    val context = LocalContext.current


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            //Minimum periodaic work is 15 minutes

            val request = PeriodicWorkRequestBuilder<MyWorkerNotification>(15,TimeUnit.MINUTES)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(context).enqueue(request)
        }) {
            Text("DO")
        }
    }
}
