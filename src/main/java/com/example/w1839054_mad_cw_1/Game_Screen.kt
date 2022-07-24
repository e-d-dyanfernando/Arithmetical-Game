package com.example.w1839054_mad_cw_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

var Timer = object: CountDownTimer((50000),1000){
    override fun onTick(millisUntilFinished: Long) { }
    override fun onFinish() { }
}

var correctCount = 0
var wrongCount = 0
var incrementCount = 0

var countdownTimer = 50000

class Game_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        var timerText = findViewById<TextView>(R.id.Timer)

        var RANDOM_EQUATION_1 = findViewById<TextView>(R.id.random_equation_1)
        var RANDOM_EQUATION_2 = findViewById<TextView>(R.id.random_equation_2)
        var correctWrong = findViewById<TextView>(R.id.crt_wrng)

        var correctValue = findViewById<TextView>(R.id.correctValue)
        var wrongValue = findViewById<TextView>(R.id.wrongValue)

        var viewBlock = findViewById<View>(R.id.viewBlock)

        var leftAWN = 0
        var rightAWn = 0

        RANDOM_EQUATION_1.text = generate()
        RANDOM_EQUATION_2.text = generate()

        leftAWN = formulasolver(RANDOM_EQUATION_1.text.toString())
        rightAWn = formulasolver(RANDOM_EQUATION_2.text.toString())

        Log.i("Right AWn", rightAWn.toString())
        Log.i("left AWn", leftAWN.toString())

        findViewById<Button>(R.id.greater).setOnClickListener {

            leftAWN = formulasolver(RANDOM_EQUATION_1.text.toString())
            rightAWn = formulasolver(RANDOM_EQUATION_2.text.toString())

            if (leftAWN > rightAWn) {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Correct")
                correctWrong.setTextColor(Color.GREEN)
                correctCount = correctCount + 1
                incrementCount = incrementCount + 1

            } else {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Wrong")
                correctWrong.setTextColor(Color.RED)
                wrongCount = wrongCount + 1
            }

            Log.i("increment", incrementCount.toString())

            var currectTime = ((timerText.text).toString().toInt()) * 1000

            if (incrementCount >= 5) {
                incrementCount = 0

                Log.i("T", currectTime.toString())
                var newTime = currectTime + 10000
                Log.i("TNew", newTime.toString())

                Timer.cancel()
                Timer = object : CountDownTimer((newTime.toLong()), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timerText.text = (millisUntilFinished / 1000).toString()
                    }

                    override fun onFinish() {

                        findViewById<TextView>(R.id.CorrectView).visibility = View.VISIBLE
                        findViewById<TextView>(R.id.wrongView).visibility = View.VISIBLE
                        findViewById<Button>(R.id.greater).visibility = View.GONE
                        findViewById<Button>(R.id.less).visibility = View.GONE
                        findViewById<Button>(R.id.equal).visibility = View.GONE

                        viewBlock.visibility = View.VISIBLE
                        correctValue.visibility = View.VISIBLE
                        wrongValue.visibility = View.VISIBLE
                        correctValue.text = correctCount.toString()
                        wrongValue.text = wrongCount.toString()

                    }
                }.start()

            }

            RANDOM_EQUATION_1.text = generate()
            RANDOM_EQUATION_2.text = generate()
        }

        findViewById<Button>(R.id.equal).setOnClickListener {

            leftAWN = formulasolver(RANDOM_EQUATION_1.text.toString())
            rightAWn = formulasolver(RANDOM_EQUATION_2.text.toString())

            if (leftAWN == rightAWn) {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Correct")
                correctWrong.setTextColor(Color.GREEN)
                correctCount = correctCount + 1
                incrementCount = incrementCount + 1

            } else {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Wrong")
                correctWrong.setTextColor(Color.RED)
                wrongCount = wrongCount + 1
            }

            Log.i("increment", incrementCount.toString())

            var currectTime = ((timerText.text).toString().toInt()) * 1000

            if (incrementCount >= 5) {
                incrementCount = 0

                Log.i("T", currectTime.toString())
                var newTime = currectTime + 10000
                Log.i("TNew", newTime.toString())

                Timer.cancel()
                Timer = object : CountDownTimer((newTime.toLong()), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timerText.text = (millisUntilFinished / 1000).toString()
                    }

                    override fun onFinish() {

                        findViewById<TextView>(R.id.CorrectView).visibility = View.VISIBLE
                        findViewById<TextView>(R.id.wrongView).visibility = View.VISIBLE
                        findViewById<Button>(R.id.greater).visibility = View.GONE
                        findViewById<Button>(R.id.less).visibility = View.GONE
                        findViewById<Button>(R.id.equal).visibility = View.GONE

                        viewBlock.visibility = View.VISIBLE
                        correctValue.visibility = View.VISIBLE
                        wrongValue.visibility = View.VISIBLE
                        correctValue.text = correctCount.toString()
                        wrongValue.text = wrongCount.toString()

                    }
                }.start()

            }

            RANDOM_EQUATION_1.text = generate()
            RANDOM_EQUATION_2.text = generate()
        }

        findViewById<Button>(R.id.less).setOnClickListener {

            leftAWN = formulasolver(RANDOM_EQUATION_1.text.toString())
            rightAWn = formulasolver(RANDOM_EQUATION_2.text.toString())

            if (leftAWN < rightAWn) {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Correct")
                correctWrong.setTextColor(Color.GREEN)
                correctCount = correctCount + 1
                incrementCount = incrementCount + 1

            } else {
                correctWrong.visibility = View.VISIBLE
                correctWrong.setText("Wrong")
                correctWrong.setTextColor(Color.RED)
                wrongCount = wrongCount + 1
            }

            Log.i("increment", incrementCount.toString())

            var currectTime = ((timerText.text).toString().toInt()) * 1000

            if (incrementCount >= 5) {
                incrementCount = 0

                Log.i("T", currectTime.toString())
                var newTime = currectTime + 10000
                Log.i("TNew", newTime.toString())

                Timer.cancel()
                Timer = object : CountDownTimer((newTime.toLong()), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timerText.text = (millisUntilFinished / 1000).toString()
                    }

                    override fun onFinish() {

                        findViewById<TextView>(R.id.CorrectView).visibility = View.VISIBLE
                        findViewById<TextView>(R.id.wrongView).visibility = View.VISIBLE
                        findViewById<Button>(R.id.greater).visibility = View.GONE
                        findViewById<Button>(R.id.less).visibility = View.GONE
                        findViewById<Button>(R.id.equal).visibility = View.GONE

                        viewBlock.visibility = View.VISIBLE
                        correctValue.visibility = View.VISIBLE
                        wrongValue.visibility = View.VISIBLE
                        correctValue.text = correctCount.toString()
                        wrongValue.text = wrongCount.toString()

                    }
                }.start()

            }

            RANDOM_EQUATION_1.text = generate()
            RANDOM_EQUATION_2.text = generate()
        }

        Timer = object : CountDownTimer((countdownTimer.toLong()), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {

                findViewById<TextView>(R.id.CorrectView).visibility = View.VISIBLE
                findViewById<TextView>(R.id.wrongView).visibility = View.VISIBLE
                findViewById<Button>(R.id.greater).visibility = View.GONE
                findViewById<Button>(R.id.less).visibility = View.GONE
                findViewById<Button>(R.id.equal).visibility = View.GONE

                viewBlock.visibility = View.VISIBLE
                correctValue.visibility = View.VISIBLE
                wrongValue.visibility = View.VISIBLE
                correctValue.text = correctCount.toString()
                wrongValue.text = wrongCount.toString()

            }
        }.start()

    }

    fun generate(): String {

        val operations_list = listOf("/", "*", "+", "-")

        var gen: Random = Random()
        var new_number_1 = gen.nextInt(20 - 1) + 1
        var new_number_2 = gen.nextInt(20 - 1) + 1
        var new_number_3 = gen.nextInt(20 - 1) + 1
        var new_number_4 = gen.nextInt(20 - 1) + 1
        var new_number_5 = gen.nextInt(20 - 1) + 1

        var random_operator = gen.nextInt(operations_list.size - 1) + 1
        var random_equation = " "
        var number_components = gen.nextInt(3 - 1) + 1

        when (number_components) {
            0 -> random_equation =
                new_number_1.toString() + operations_list[random_operator] + new_number_2.toString()
            1 -> random_equation =
                "(" + new_number_1.toString() + operations_list[random_operator] + new_number_2.toString() + ")" + operations_list[(gen.nextInt(
                    operations_list.size - 1
                ) + 1)] + new_number_3
            2 -> random_equation =
                "((" + new_number_1.toString() + operations_list[random_operator] + new_number_2.toString() + ")" + operations_list[(gen.nextInt(
                    operations_list.size - 1
                ) + 1)] + new_number_3 + ")" + operations_list[(gen.nextInt(operations_list.size - 1) + 1)] + new_number_4
            3 -> random_equation =
                "(((" + new_number_1.toString() + operations_list[random_operator] + new_number_2.toString() + ")" + operations_list[(gen.nextInt(
                    operations_list.size - 1
                ) + 1)] + new_number_3 + ")" + operations_list[(gen.nextInt(operations_list.size - 1) + 1)] + new_number_4 + ")" + operations_list[(gen.nextInt(
                    operations_list.size - 1
                ) + 1)] + new_number_4
        }
        return random_equation
    }

    fun formulasolver(formula: String): Int {
        var restlts = 0
        var formulaOP = formula.split(")")
        var count = 0
        var rightSide = ""
        var leftSide = ""
        var operator = ""
        var status = false

        for (i in formulaOP) {
            var temp = i.replace("(", "")

            if (count == 0) {
                for (character in temp) {
                    if (character.toString().equals("+") || character.toString()
                            .equals("-") || character.toString().equals("*") || character.toString()
                            .equals("/")
                    ) {
                        status = true
                    }

                    if (status == false) {
                        leftSide = leftSide + character
                    } else {
                        rightSide = rightSide + character
                    }
                }
                rightSide = rightSide.drop(1)
                operator = temp[leftSide.length].toString()

                when (operator) {
                    "+" -> restlts = leftSide.toInt() + rightSide.toInt()
                    "-" -> restlts = leftSide.toInt() - rightSide.toInt()
                    "*" -> restlts = leftSide.toInt() * rightSide.toInt()
                    "/" -> restlts = leftSide.toInt() / rightSide.toInt()
                }

            } else {
                Log.i("formulas", temp)
                operator = temp.get(0).toString()
                leftSide = temp.drop(1)

                when (operator) {
                    "+" -> restlts = restlts + leftSide.toInt()
                    "-" -> restlts = restlts - leftSide.toInt()
                    "*" -> restlts = restlts * leftSide.toInt()
                    "/" -> restlts = restlts / leftSide.toInt()
                }
            }

            count = count + 1
        }
        return restlts
    }
}
