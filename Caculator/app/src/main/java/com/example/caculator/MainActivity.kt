package com.example.caculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.caculator.databinding.ActivityMainBinding
import java.util.Stack
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private lateinit var stackNumber: Stack<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        stackNumber = Stack()
        binding.btn0.setOnClickListener { clickButton("0") }
        binding.btn1.setOnClickListener { clickButton("1") }
        binding.btn2.setOnClickListener { clickButton("2") }
        binding.btn3.setOnClickListener { clickButton("3") }
        binding.btn4.setOnClickListener { clickButton("4") }
        binding.btn5.setOnClickListener { clickButton("5") }
        binding.btn6.setOnClickListener { clickButton("6") }
        binding.btn7.setOnClickListener { clickButton("7") }
        binding.btn8.setOnClickListener { clickButton("8") }
        binding.btn9.setOnClickListener { clickButton("9") }
        binding.btnDot.setOnClickListener { clickButton(".") }

        binding.btnPlus.setOnClickListener { clickButton(" + ") }
        binding.btnMinus.setOnClickListener { clickButton(" - ") }
        binding.btnMultiply.setOnClickListener { clickButton(" * ") }
        binding.btnDivide.setOnClickListener { clickButton(" / ") }
        binding.btnModulo.setOnClickListener { clickButton(" % ") }
        binding.btnPow.setOnClickListener { clickButton(" ^ ") }

        binding.btnEqual.setOnClickListener { calculate() }
        binding.btnClear.setOnClickListener { clear() }
    }

    private fun clickButton(click: String) {
        input += click
        binding.tvInput.text = input
    }

    private fun calculate() {
        var postfixOutput = postfixConverter(input)
        Log.d("POSTFIX", postfixOutput)
        var output = calculatePostfix(postfixOutput)
        if (output == output?.toInt()?.toDouble()) {
            binding.tvOutput.text = output?.toInt().toString()
        } else {
            binding.tvOutput.text = output?.toString()
        }
    }

    private fun clear() {
        input = ""
        stackNumber.clear()
        binding.tvInput.text = ""
        binding.tvOutput.text = ""
    }

    private fun postfixConverter(input: String): String {
        val operatorStack = Stack<Char>()
        var result = ""
        for (i in input.indices) {
            if (numberCheck(input[i])) {
                result += input[i]
            } else if (input[i] == ' ') {
                if (result[result.length - 1] == ' ') {
                    continue
                } else {
                    result += input[i]
                }
            } else {
                while (operatorStack.isNotEmpty() && checkPriority(input[i]) <= checkPriority(
                        operatorStack.peek()
                    )
                ) {
                    result += operatorStack.pop()
                }
                operatorStack.push(input[i])
            }
        }
        while (operatorStack.isNotEmpty()) {
            result += " " + operatorStack.pop()
        }
        return result
    }

    private fun calculatePostfix(input: String): Double? {
        val stack = Stack<Double>()
        var buffer = ""
        for (i in input.indices) {
            if (numberCheck(input[i])) {
                buffer += input[i]
            } else if (input[i] == ' ') {
                if (buffer == "") {
                    continue
                }
                stack.push(buffer.toDouble())
                buffer = ""
            } else {
                val a = stack.pop()
                val b = stack.pop()
                when (input[i]) {
                    '+' -> stack.push(a + b)
                    '-' -> stack.push(b - a)
                    '*' -> stack.push(a * b)
                    '/' -> stack.push(b / a)
                    '%' -> stack.push(b % a)
                    '^' -> stack.push(b.pow(a))
                }
            }
        }
        return stack.pop()
    }

    private fun numberCheck(input: Char): Boolean {
        return input in '0'..'9' || input == '.'
    }

    private fun checkPriority(input: Char): Int {
        return when (input) {
            '+', '-' -> 1
            '*', '/', '%' -> 2
            '^' -> 3
            else -> -1
        }
    }
}