package com.cheng.jetpack_basic.workManager

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import timber.log.Timber

class DemoWorker(@NonNull context: Context?, @NonNull workerParams: WorkerParameters?) :
    Worker(context!!, workerParams!!) {
    @NonNull
    override fun doWork(): Result {

        val data = inputData.getInt("count", 1)

        for (i in 0..data) {
            Timber.i("i : $i")
        }

        val toBeSent = Data.Builder().putString("message", "Yay! Success")

        return Result.success(toBeSent.build())
    }
}