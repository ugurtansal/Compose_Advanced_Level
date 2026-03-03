package com.ugurtansal.traning_advanced_level.work_manager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {


    //Arka planda yapılacak işlemler
    override fun doWork(): Result {
       val add=10+20
        Log.e("Backplan",add.toString())

        return Result.success()
    }
}