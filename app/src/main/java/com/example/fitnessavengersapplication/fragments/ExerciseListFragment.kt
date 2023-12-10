package com.example.fitnessavengersapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.activityViewModels
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.adapters.ExerciseAdapter
import com.example.fitnessavengersapplication.databinding.FragmentExerciseListBinding
import com.example.fitnessavengersapplication.utils.MainViewModel


class ExerciseListFragment : Fragment() {
    private lateinit var adapter: ExerciseAdapter
    lateinit var binding: FragmentExerciseListBinding
    private val model: MainViewModel by activityViewModels()
    private var ab: ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentExerciseListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.mutableListExercise.observe(viewLifecycleOwner){
            for( i in 0 until model.getExerciseCount()){
                it[i] = it[i].copy(isDone = true)
            }
            adapter.submitList(it)
        }
    }




    companion object {
        @JvmStatic
        fun newInstance() = ExerciseListFragment()
    }
}