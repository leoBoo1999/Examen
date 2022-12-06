package com.example.combignerdranchandroidgeoquiz


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

private const val TAG = "QuizViewModel"
const val CURRENT_RESULT_FINAL = "CURRENT_RESULT_FINAL"
const val CURRENT_OPERATIONF = "CURRENT_OPERATIONF"
const val CURRENT_OPERATIONDO = "CURRENT_OPERATIONDO"
class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {


    var resultFinal: Int
    get() = savedStateHandle.get(CURRENT_RESULT_FINAL) ?: 4
        set(value) = savedStateHandle.set(CURRENT_RESULT_FINAL, value)

    var operationF : String
        get() = savedStateHandle.get(CURRENT_OPERATIONF) ?: "3+1"
        set(value) = savedStateHandle.set(CURRENT_OPERATIONF, value)

    var operationDo : String
        get() = savedStateHandle.get(CURRENT_OPERATIONDO) ?: "+"
        set(value) = savedStateHandle.set(CURRENT_OPERATIONDO, value)


    var number3: Int = 0



    fun moveToNext() {


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



    }
}