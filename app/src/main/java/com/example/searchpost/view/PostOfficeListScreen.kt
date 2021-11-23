package com.example.searchpost.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchpost.R
import com.example.searchpost.databinding.FragmentPostOfficeListScreenBinding
import com.example.searchpost.list.OnItemClickListener
import com.example.searchpost.list.PostOfficeAdapter
import com.example.searchpost.network.PostOffice
import com.example.searchpost.viewmodel.PostOfficeViewModel


class PostOfficeListScreen : Fragment(), OnItemClickListener {
private lateinit var binding : FragmentPostOfficeListScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostOfficeListScreenBinding.inflate(layoutInflater)
        val postOfficeViewModel= ViewModelProvider(this).get(PostOfficeViewModel::class.java)
       val adapter = PostOfficeAdapter(this)
        binding.recyclerView.adapter = adapter
        postOfficeViewModel.listOfPostOffice.observe(viewLifecycleOwner , {list ->
            if(list!=null)
                adapter.refreshPostOfficeList(list)
        })
        return binding.root
    }

    override fun onClick(postOffice: PostOffice, position: Int) {
        Toast.makeText(context, "clicked on ${postOffice.Name}", Toast.LENGTH_SHORT).show()
    }

}