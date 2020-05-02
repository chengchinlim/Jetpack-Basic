package com.cheng.jetpack_basic.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.ListItemBinding
import com.cheng.jetpack_basic.room.database.Subscriber

class MyRecyclerViewAdapter(private val clickListener: (Subscriber) -> Unit)
    : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    private val subscribersList = ArrayList<Subscriber>()

    fun setList(subscribers: List<Subscriber>) {
        subscribersList.clear()
        subscribersList.addAll(subscribers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding
                = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
            binding.nameTv.text = subscriber.name
            binding.emailTv.text = subscriber.email
            binding.itemLayout.setOnClickListener {
                clickListener(subscriber)
            }
        }
    }
}