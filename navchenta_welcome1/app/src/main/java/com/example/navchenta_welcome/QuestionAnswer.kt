package com.example.navchenta_welcome

import androidx.appcompat.app.AppCompatActivity

class QuestionAnswer : AppCompatActivity(){
    val question=arrayOf("What is the capital of India?",
    "Which one of the languages is made by google?",
    "What is 2 times 3?")
    val choices: Array<Array<String>> = arrayOf(
        arrayOf("Delhi","Bangalore","Kolkata","Punjab"),
        arrayOf("java","python","kotlin","cpp"),
        arrayOf("5","3","6","21")
    )
    val correctAnswers=arrayOf("Delhi","kotlin","6")
}