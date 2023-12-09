package com.example.fitnessavengersapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.adapters.DayModel
import com.example.fitnessavengersapplication.adapters.DaysAdapter
import com.example.fitnessavengersapplication.databinding.FragmentDaysBinding


class DaysFragment : Fragment() {
    lateinit var binding : FragmentDaysBinding
    private var ab : ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    private fun initRcView() = with(binding){
        val adapter = DaysAdapter()
        rcViewDays.adapter = adapter
        rcViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        adapter.submitList(fillDaysArray())
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