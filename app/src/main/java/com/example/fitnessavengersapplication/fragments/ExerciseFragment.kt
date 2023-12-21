package com.example.fitnessavengersapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitnessavengersapplication.R
import com.example.fitnessavengersapplication.adapters.ExerciseModel
import com.example.fitnessavengersapplication.databinding.ExerciseBinding
import com.example.fitnessavengersapplication.utils.FragmentManager
import com.example.fitnessavengersapplication.utils.MainViewModel
import com.example.fitnessavengersapplication.utils.TimeUtils
import pl.droidsonroids.gif.GifDrawable


class ExerciseFragment : Fragment() {
    private var timer : CountDownTimer? = null
    lateinit var binding : ExerciseBinding
    private val model : MainViewModel by activityViewModels()
    private var exerciseCounter = 0
    private var exList : ArrayList<ExerciseModel>? = null
    private var ab : ActionBar? = null
    private var currentDay = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExerciseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentDay = model.currentDay
        exerciseCounter = model.getExerciseCount()
        ab = (activity as AppCompatActivity).supportActionBar
        model.mutableListExercise.observe(viewLifecycleOwner){
            exList = it
            nextExercise()
        }
        binding.btnNext.setOnClickListener{
            nextExercise()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun nextExercise(){
        if(exerciseCounter < exList?.size!!){
            val ex = exList?.get(exerciseCounter++)  ?: return
            showExercise(ex)
            setExerciseType(ex)
            showNextExercise()
        }else{
            exerciseCounter++
            FragmentManager.setFragment(DayFinishFragment.newInstance(), activity as AppCompatActivity)
        }
    }

    private fun showNextExercise() = with(binding){
        if(exerciseCounter < exList?.size!!){
            val ex = exList?.get(exerciseCounter) ?: return
            imNext.setImageDrawable(GifDrawable(root.context.assets,ex.image))
            setTimeType(ex)
        }else{
            imNext.setImageDrawable(GifDrawable(root.context.assets,"congrats-congratulations.gif"))
            txtNextName.text = getText(R.string.done)
        }
    }

    private fun setTimeType(exerciseModel: ExerciseModel){
        if(exerciseModel.time.startsWith("x")){
            binding.txtNextName.text = exerciseModel.time
        }else{
            val name = exerciseModel.name + ": ${TimeUtils.getTime(exerciseModel.time.toLong() * 1000)}"
            binding.txtNextName.text = name
        }
    }


    private fun showExercise(exerciseModel: ExerciseModel) = with(binding){

        imMain.setImageDrawable(GifDrawable(root.context.assets,exerciseModel.image))
        txtExerName.text = exerciseModel.name
        val title  = "$exerciseCounter / ${exList?.size}"
        ab?.title = title


    }


    private fun setExerciseType(exerciseModel: ExerciseModel){
        if(exerciseModel.time.startsWith("x")){
            timer?.cancel()
            binding.progressBar.progress = 0
            binding.txtExerTime.text = exerciseModel.time
        }else{
            startTimer(exerciseModel)
        }
    }

    private fun startTimer(exerciseModel: ExerciseModel) = with(binding){
        progressBar.max = exerciseModel.time.toInt() * 1000
        timer?.cancel()
        timer = object : CountDownTimer(exerciseModel.time.toLong() * 1000,1){
            override fun onTick(restTime: Long) {
                txtExerTime.text = TimeUtils.getTime(restTime)
                progressBar.progress = restTime.toInt()
            }

            override fun onFinish() {
                nextExercise()
            }

        }.start()
    }

    override fun onDetach() {
        super.onDetach()
        model.savePref(currentDay.toString(), exerciseCounter - 1)
        timer?.cancel()
    }


    companion object {
// companion object of newinstance
        @JvmStatic
        fun newInstance() = ExerciseFragment()
    }
}