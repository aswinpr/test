package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var inputDisplay: TextView
    private lateinit var outputDisplay: TextView
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0
    private var currentOperation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputDisplay = findViewById(R.id.input)
        outputDisplay = findViewById(R.id.output)
        val buttons = listOf<Button>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9),
            findViewById(R.id.add),
            findViewById(R.id.subtract),
            findViewById(R.id.multiply),
            findViewById(R.id.divide),
            findViewById(R.id.equal),
            findViewById(R.id.btnClear)
        )
        for (button in buttons) {
            button.setOnClickListener { onButtonClick(button) }
        }
    }

    private fun onButtonClick(button: Button) {
        when (button.id) {
            R.id.btnClear -> clear()
            R.id.equal -> calculateResult()
            in listOf(R.id.add, R.id.subtract, R.id.multiply, R.id.divide) -> setOperation(button.text.toString())
            else -> appendToInput(button.text.toString())
        }
    }

    private fun clear() {
        inputDisplay.text = ""
        outputDisplay.text = ""
        firstValue = 0.0
        secondValue = 0.0
        currentOperation = null
    }

    private fun appendToInput(value: String) {
        inputDisplay.append(value)
    }

    private fun setOperation(operation: String) {
        if (inputDisplay.text.isNotEmpty()) {
            firstValue = inputDisplay.text.toString().toDouble()
            currentOperation = operation
            inputDisplay.text = ""
        }
    }

    private fun calculateResult() {
        if (inputDisplay.text.isNotEmpty() && currentOperation != null) {
            secondValue = inputDisplay.text.toString().toDouble()
            val result = when (currentOperation) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "*" -> firstValue * secondValue
                "/" -> if (secondValue != 0.0) firstValue / secondValue else Double.NaN
                else -> 0.0
            }
            outputDisplay.text = result.toString()
            currentOperation = null
        }
    }
}