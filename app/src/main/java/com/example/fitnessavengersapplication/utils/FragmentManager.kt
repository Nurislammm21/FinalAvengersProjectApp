package com.example.fitnessavengersapplication.utils

import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessavengersapplication.R
import androidx.fragment.app.Fragment as SupportFragment

object FragmentManager {
    var currentFragment: SupportFragment? = null

    fun setFragment(newFragment: SupportFragment, act: AppCompatActivity) {
        val transaction = act.supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            android.R.anim.slide_in_left,
            android.R.anim.slide_out_right
        )
        transaction.replace(R.id.placeHolder, newFragment)
        transaction.commit()
        currentFragment = newFragment
    }
}