package com.example.a160419034_homeworkweek2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.math.log
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var randomNum1 = Random.nextInt(100)
        var randomNum2 = Random.nextInt(50)

        var score = 0

        textNumber1.text = "$randomNum1"
        textNumber2.text = "$randomNum2"
        textScoreValue.text = "$score"

        buttonSubmit.setOnClickListener {

            var answer = textInputAnswer.text
            val result = textNumber1.text.toString().toInt() + textNumber2.text.toString().toInt()
            if ("$answer" == "$result")
            {
                score += 1
                textScoreValue.text = score.toString()

                var randomNum1 = Random.nextInt(100)
                var randomNum2 = Random.nextInt(50)

                textNumber1.text = "$randomNum1"
                textNumber2.text = "$randomNum2"

                textInputAnswer.setText("")

            }
            else {
                val action = GameFragmentDirections.actionToResult(score.toString())
                //Jalankan action tersebut
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}