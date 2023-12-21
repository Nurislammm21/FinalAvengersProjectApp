package com.example.fitnessavengersapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.databinding.DayFinishBinding
import com.example.fitnessavengersapplication.utils.FragmentManager
import pl.droidsonroids.gif.GifDrawable


class DayFinishFragment : Fragment() {
 lateinit var binding : DayFinishBinding
    private var ab : ActionBar? = null


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
      binding = DayFinishBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ab = (activity as AppCompatActivity).supportActionBar
        ab?.title = getString(R.string.done)
                binding.imMainFInishDay.setImageDrawable(GifDrawable((activity as AppCompatActivity).assets,"congrats-congratulations.gif"))

                binding.btnDoneFinishDay.setOnClickListener{
                  FragmentManager.setFragment(DaysFragment.newInstance(),activity as AppCompatActivity)
                }

    }





    companion object {

        @JvmStatic
        fun newInstance() = DayFinishFragment()
    }
}