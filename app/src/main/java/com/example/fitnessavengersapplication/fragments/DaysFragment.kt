package com.example.fitnessavengersapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.activityViewModels
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.adapters.DayModel
import com.example.fitnessavengersapplication.adapters.DaysAdapter
import com.example.fitnessavengersapplication.databinding.FragmentDaysBinding


class DaysFragment : Fragment() {
    private lateinit var adapter : DaysAdapter
    lateinit var binding : FragmentDaysBinding
    private var ab : ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun fillDaysArray(): ArrayList<DayModel>{
        val tArray = ArrayList<DayModel>()
        var daysDoneCounter = 0
        resources.getStringArray(R.array.day_exercises).forEach {
           tArray.add(DayModel(it,false))
        }

        return tArray

    }

    companion object {

        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}