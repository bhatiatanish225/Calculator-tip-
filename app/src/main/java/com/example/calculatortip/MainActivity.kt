package com.example.calculatortip

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // edit text
    private lateinit var amountEditText: EditText

    // buttons to take input
    private lateinit var button15: Button
    private lateinit var button18: Button
    private lateinit var button20: Button

    // view result
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the elements
        initializeElements()

        // Setup click handlers for % buttons
        clickHandlers()
    }

    // Setup click handlers for buttons
    private fun clickHandlers() {
        button15.setOnClickListener {
            calculateTip(15)
        }

        button18.setOnClickListener {
            calculateTip(18)
        }

        button20.setOnClickListener {
            calculateTip(20)
        }
    }

    // Initialize Elements
    private fun initializeElements() {
        amountEditText = findViewById(R.id.amountEditText)
        button15 = findViewById(R.id.button15Percent)
        button18 = findViewById(R.id.button18Percent)
        button20 = findViewById(R.id.button20Percent)
        resultTextView = findViewById(R.id.tipAmountTextView)
    }

    // Calculate Tip
    private fun calculateTip(percent: Int) {
        val amountStr = amountEditText.text.toString()

        if (amountStr.isNotEmpty()) {
            val amount = amountStr.toDouble()
            val tip = (amount * percent) / 100
            val totalBill = amount + tip

            val resultText = "Tip: $%.2f, Total Bill: $%.2f".format(tip, totalBill)
            resultTextView.text = resultText
        } else {
            resultTextView.text = "Please enter an amount."
        }
    }
}
