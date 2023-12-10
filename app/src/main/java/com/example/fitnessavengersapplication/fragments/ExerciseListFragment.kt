package com.example.fitnessavengersapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.databinding.FragmentExerciseListBinding


class ExerciseListFragment : Fragment() {
    lateinit var binding: FragmentExerciseListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentExerciseListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExerciseListFragment()
    }
}