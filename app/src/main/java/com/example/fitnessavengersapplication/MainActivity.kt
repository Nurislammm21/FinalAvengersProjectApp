package com.example.fitnessavengersapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.fitnessavengersapplication.databinding.ActivityMainBinding
import com.example.fitnessavengersapplication.fragments.DaysFragment
import com.example.fitnessavengersapplication.utils.FragmentManager
import com.example.fitnessavengersapplication.utils.MainViewModel

class MainActivity : AppCompatActivity() {
    private val model : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model.pref = getSharedPreferences("main", MODE_PRIVATE)
        FragmentManager.setFragment(DaysFragment.newInstance(),this)

    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(FragmentManager.currentFragment is DaysFragment) super.onBackPressed()
        else FragmentManager.setFragment(DaysFragment.newInstance(), this)


    }
}