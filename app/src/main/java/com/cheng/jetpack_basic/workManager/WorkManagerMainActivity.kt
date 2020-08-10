package com.cheng.jetpack_basic.workManager

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.work.*
import com.cheng.jetpack_basic.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import timber.log.Timber

class WorkManagerMainActivity : AppCompatActivity() {
    private lateinit var status: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_work_manager)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        Timber.plant(Timber.DebugTree())
        status = findViewById(R.id.status_text)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)

        val data = Data.Builder().putInt("count", 1000)

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<DemoWorker>()
            .setInputData(data.build())
            .setConstraints(constraints.build())
            .build()

        val fab: FloatingActionButton = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            WorkManager.getInstance(applicationContext)
                .enqueue(oneTimeWorkRequest)
        }

        WorkManager.getInstance(applicationContext)
            .getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, Observer {
                when (it.state) {
                    WorkInfo.State.ENQUEUED -> {
                        status.text = getString(R.string.enqueued)
                    }
                    WorkInfo.State.RUNNING -> {
                        status.text = getString(R.string.running)
                    }
                    WorkInfo.State.SUCCEEDED -> {
                        status.text = getString(R.string.succeeded)
                    }
                    else -> {

                    }
                }
                if (it.state.isFinished) {
                    val receivedData = it.outputData
                    Timber.i("Received: ${receivedData.getString("message")}")
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}