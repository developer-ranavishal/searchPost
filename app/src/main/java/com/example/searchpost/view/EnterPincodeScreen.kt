package com.example.searchpost.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.searchpost.databinding.FragmentEnterPincodeScreenBinding
import com.example.searchpost.list.OnItemClickListener
import com.example.searchpost.list.PostOfficeAdapter
import com.example.searchpost.network.PostOffice
import com.example.searchpost.viewmodel.PostOfficeViewModel


class EnterPincodeScreen : Fragment() {
    private lateinit var binding: FragmentEnterPincodeScreenBinding
    private var pinCode: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPincodeScreenBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this).get(PostOfficeViewModel::class.java)
        binding.searchButton.setOnClickListener {
            pinCode = binding.enterPinEdittext.text.toString().toIntOrNull() ?: 0
            if (pinCode <= 99999)
                Toast.makeText(context, "please enter correct pin!", Toast.LENGTH_SHORT).show()
            else {
                viewModel.getPostByPin(pinCode)
                val action =
                    EnterPincodeScreenDirections.actionEnterPincodeScreenToPostOfficeListScreen()
                findNavController().navigate(action)
                Toast.makeText(context, "done it!", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.listOfPostOffice.observe(viewLifecycleOwner, {

        })
        return binding.root
    }


}

