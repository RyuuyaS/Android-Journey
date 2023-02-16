package com.example.caculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.caculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var input: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn0.setOnClickListener { clickButton("0", false) }
        binding.btn1.setOnClickListener { clickButton("1", false) }
        binding.btn2.setOnClickListener { clickButton("2", false) }
        binding.btn3.setOnClickListener { clickButton("3", false) }
        binding.btn4.setOnClickListener { clickButton("4", false) }
        binding.btn5.setOnClickListener { clickButton("5", false) }
        binding.btn6.setOnClickListener { clickButton("6", false) }
        binding.btn7.setOnClickListener { clickButton("7", false) }
        binding.btn8.setOnClickListener { clickButton("8", false) }
        binding.btn9.setOnClickListener { clickButton("9", false) }
        binding.btnDot.setOnClickListener { clickButton(".", false) }

        binding.btnPlus.setOnClickListener { clickButton(" + ", true) }
        binding.btnMinus.setOnClickListener { clickButton(" - ", true) }
        binding.btnMultiply.setOnClickListener { clickButton(" * ", true) }
        binding.btnDivide.setOnClickListener { clickButton(" / ", true) }
        binding.btnModulo.setOnClickListener { clickButton(" % ", true) }

        binding.btnEqual.setOnClickListener { caculate() }
        binding.btnClear.setOnClickListener { clear() }
    }

    private fun clickButton(click: String, endNumber: Boolean) {
        input += click
        if (!endNumber) {
            binding.tvInput.text = input
        } else {
            binding.tvInput.text = input
        }
    }

    private fun caculate() {
        val arr = input.trim().split(" ").map { it -> it.trim() }.toMutableList()
        if (arr.size >= 3) {
            caculateHigherPriority(arr)
            caculateLowerPriority(arr)
            binding.tvOutput.text = arr[0]
        } else {
            binding.tvOutput.text = "0"
        }
    }

    private fun checkPriority(operator: String, input1: String, input2: String): Long {
        return when (operator.trim()) {
            "*" -> input1.toLong() * input2.toLong()
            "/" -> input1.toLong() / input2.toLong()
            "%" -> input1.toLong() % input2.toLong()
            "+" -> input1.toLong() + input2.toLong()
            "-" -> input1.toLong() - input2.toLong()
            else -> 0
        }
    }

    private fun clear() {
        input = ""
        binding.tvInput.text = ""
        binding.tvOutput.text = ""
    }

    private fun caculateHigherPriority(arr: MutableList<String>) {
        var i = 1
        while (i < arr.size) {
            if (arr[i] == "*" || arr[i] == "/" || arr[i] == "%") {
                arr[i - 1] = checkPriority(arr[i], arr[i - 1], arr[i + 1]).toString()
                arr.removeAt(i)
                arr.removeAt(i)
            } else {
                i += 2
            }
        }
    }

    private fun caculateLowerPriority(arr: MutableList<String>) {
        var i = 1
        while (arr.size >= 3) {
            arr[i - 1] = checkPriority(arr[i], arr[i - 1], arr[i + 1]).toString()
            Log.d("VALUE", arr.joinToString())
            arr.removeAt(i)
            arr.removeAt(i)
        }
    }
}