package com.example.fitnessavengersapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessavengersapplication.fragments.DaysFragment
import com.example.fitnessavengersapplication.utils.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(DaysFragment.newInstance(),this)
    }
}