package com.example.combignerdranchandroidgeoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlin.random.Random

import com.example.combignerdranchandroidgeoquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    private var resultFinal: Int = 0
    private var operationF : String = ""
    private var operationDo : String = ""
    private var number3: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        update()
        binding.check.setOnClickListener{
            checkAnswer()
        }
        }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun update() {

        binding.edit.text.clear()
        val listOperations = listOf("+",'-','*')

        val number1 = Random.nextInt(0,11)
        val number2 = Random.nextInt(0,11)
        number3 =  Random.nextInt(0,3)
        operationDo = listOperations[number3].toString()

        when(operationDo){
            "+"->{
                resultFinal = number1+number2
                operationF = "$number1 + $number2 "
            }
            "-"->{
                resultFinal = number1-number2
                operationF = "$number1 - $number2 "
            }
            "*"->{
                resultFinal = number1*number2
                operationF= "$number1 x $number2 "
            }
        }

        binding.textview.text = operationF

    }


    private fun checkAnswer() {

        if(binding.edit.text.isEmpty()){
            Toast.makeText(this,R.string.mensaje, Toast.LENGTH_LONG).show()
        return}

        val res= if(binding.edit.text.toString()== resultFinal.toString()){
            R.string.correct

        }else{
            R.string.incorrect

        }
        val colorBackground= if(binding.edit.text.toString()== resultFinal.toString()){
            R.color.green
        }else{
            R.color.red
        }

        val mySnack = Snackbar.make(binding.root,res, Snackbar.LENGTH_LONG)
        mySnack.setBackgroundTint(getColor(colorBackground))
        mySnack.show()

        if(binding.edit.text.toString()== resultFinal.toString()){
            update()


        }
    }}
