package com.example.searchpost.list

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchpost.databinding.PostOfficeItemBinding
import com.example.searchpost.network.PostOffice
import com.example.searchpost.view.EnterPincodeScreen

class PostOfficeAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<PostOfficeAdapter.PostOfficeViewHolder>() {
    private var  postOfficeList  = listOf<PostOffice>()
    class PostOfficeViewHolder(private val binding : PostOfficeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindingPostOffice(postOffice : PostOffice){
            binding.postOffice = postOffice
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
       PostOfficeViewHolder(PostOfficeItemBinding.inflate(LayoutInflater.from(parent.context)))



    override fun onBindViewHolder(holder: PostOfficeViewHolder, position: Int) {
        Log.d("onbind", "onBindViewHolder: called()")
        val currentItem= postOfficeList[position]

        holder.bindingPostOffice(currentItem)
        holder.itemView.setOnClickListener {
            listener.onClick(currentItem,position)
        }

    }

    override fun getItemCount() = postOfficeList.size


    @SuppressLint("NotifyDataSetChanged")
    fun refreshPostOfficeList(newPostOfficeList : List<PostOffice>){
        postOfficeList = newPostOfficeList
        notifyDataSetChanged()    // imp line to refresh new data in recyclerview
    }
}

    interface OnItemClickListener {
    fun onClick(postOffice : PostOffice,position: Int)
      }