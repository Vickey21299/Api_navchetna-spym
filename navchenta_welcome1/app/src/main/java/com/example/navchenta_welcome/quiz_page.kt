package com.example.navchenta_welcome
import android.graphics.Color
import com.example.navchenta_welcome.QuestionAnswer

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class quiz_page : AppCompatActivity(), View.OnClickListener {
    var score =0
    var totalQuestion=QuestionAnswer().question.size
    var currentQuestionInd=0
    var selectedAnswer=""
    lateinit var questionTextView: TextView
    lateinit var ansA: Button
    lateinit var ansB: Button
    lateinit var ansC: Button
    lateinit var ansD: Button
    lateinit var submit_btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val totalQuestionTextView = findViewById<TextView>(R.id.total_question)
        questionTextView = findViewById<TextView>(R.id.question)
        ansA = findViewById<Button>(R.id.ans_A)
        ansB = findViewById<Button>(R.id.ans_B)
        ansC = findViewById<Button>(R.id.ans_C)
        ansD = findViewById<Button>(R.id.ans_D)
        submit_btn = findViewById<Button>(R.id.submit_Btn)
        ansA.setOnClickListener(this)
        ansB.setOnClickListener(this)
        ansC.setOnClickListener(this)
        ansD.setOnClickListener(this)
        submit_btn.setOnClickListener(this)

        totalQuestionTextView.setText("Total questions :" +totalQuestion)
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        ansA.setBackgroundColor(Color.argb(0,94,109,246))
        ansB.setBackgroundColor(Color.argb(0,94,109,246))
        ansC.setBackgroundColor(Color.argb(0,94,109,246))
        ansD.setBackgroundColor(Color.argb(0,94,109,246))

        val clickedButton = view as Button
        if (clickedButton.id == R.id.submit_Btn) {
            if (selectedAnswer == QuestionAnswer().correctAnswers[currentQuestionInd] ){
                score++
            }
            currentQuestionInd++
            loadNewQuestion()
        } else {
            // Choices button clicked
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.MAGENTA)
        }
    }


    fun loadNewQuestion(){
        if(currentQuestionInd==totalQuestion){
            finishQuiz()
            return
        }

        questionTextView.setText(QuestionAnswer().question[currentQuestionInd])
        ansA.setText(QuestionAnswer().choices[currentQuestionInd][0])
        ansB.setText(QuestionAnswer().choices[currentQuestionInd][1])
        ansC.setText(QuestionAnswer().choices[currentQuestionInd][2])
        ansD.setText(QuestionAnswer().choices[currentQuestionInd][3])
        questionTextView.setText(QuestionAnswer().question[currentQuestionInd])

    }

    private fun finishQuiz() {
        val passStatus: String = if (score > totalQuestion * 0.60) {
            "Passed"
        } else {
            "Failed"
        }

        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Score is $score out of $totalQuestion")
            .setPositiveButton("Restart") { dialogInterface, i -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionInd = 0
        loadNewQuestion()
    }

}