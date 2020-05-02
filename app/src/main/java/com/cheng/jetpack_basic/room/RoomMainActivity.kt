package com.cheng.jetpack_basic.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cheng.jetpack_basic.BuildConfig
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.ActivityRoomMainBinding
import com.cheng.jetpack_basic.room.database.Subscriber
import com.cheng.jetpack_basic.room.database.SubscriberDatabase
import com.cheng.jetpack_basic.room.database.SubscriberRepository
import timber.log.Timber

class RoomMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var adapter: MyRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_main)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.viewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter { selectedItem: Subscriber -> listItemClicked(selectedItem) }
        binding.subscriberRecyclerView.adapter = adapter
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Timber.i("Subscriber: $it")
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "Selected: ${subscriber.name}", Toast.LENGTH_SHORT).show()
        subscriberViewModel.initUpdateOrDelete(subscriber)
    }
}
