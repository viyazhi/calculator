package com.vizho.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var numberInput: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var divideButton: Button
    private lateinit var multiplyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberInput = findViewById(R.id.NUMBER)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        divideButton = findViewById(R.id.divideButton)
        multiplyButton = findViewById(R.id.multiplyButton)

        addButton.setOnClickListener { performOperation(Operation.ADD) }
        subtractButton.setOnClickListener { performOperation(Operation.SUBTRACT) }
        divideButton.setOnClickListener { performOperation(Operation.DIVIDE) }
        multiplyButton.setOnClickListener { performOperation(Operation.MULTIPLY) }
    }

    private fun performOperation(operation: Operation) {
        val inputText = numberInput.text.toString()

        if (inputText.isBlank()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            return
        }

        val number = inputText.toDouble()

        val result = when (operation) {
            Operation.ADD -> number + 2
            Operation.SUBTRACT -> number - 2
            Operation.DIVIDE -> number / 2
            Operation.MULTIPLY -> number * 2
        }

        numberInput.setText(result.toString())
    }

    private enum class Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }
}