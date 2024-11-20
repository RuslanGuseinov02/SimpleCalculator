package com.ruslanhuseynov.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruslanhuseynov.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonAc.setOnClickListener {

            binding.resultView.text = "0"
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
        }

        binding.buttonPlus.setOnClickListener {

            val num1 = binding.firstNumber.text.toString().toDoubleOrNull()
            val num2 = binding.secondNumber.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null){

                val math = Math()
                val result = math.plus(num1,num2)
                binding.resultView.text = result.toString()

            }else{
                Toast.makeText(this@MainActivity,"Enter Number",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonMinus.setOnClickListener {

            val num1 = binding.firstNumber.text.toString().toDoubleOrNull()
            val num2 = binding.secondNumber.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null){

                val math = Math()
                val result = math.minus(num1,num2)
                binding.resultView.text = result.toString()

            }else{
                Toast.makeText(this@MainActivity,"Enter Number",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonMultiply.setOnClickListener {

            val num1 = binding.firstNumber.text.toString().toDoubleOrNull()
            val num2 = binding.secondNumber.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null){

                val math = Math()
                val result = math.multiply(num1,num2)
                binding.resultView.text = result.toString()

            }else{
                Toast.makeText(this@MainActivity,"Enter Number",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonDiv.setOnClickListener {

            val num1 = binding.firstNumber.text.toString().toDoubleOrNull()
            val num2 = binding.secondNumber.text.toString().toDoubleOrNull()

            if (num1 != num2 &&  num2 != null){

                val math = Math()
                val result = math.div(num1!!,num2)
                binding.resultView.text = result.toString()

            }else{
                Toast.makeText(this@MainActivity,"Enter Number",Toast.LENGTH_SHORT).show()
            }

            if (num2 == 0.0){
                binding.resultView.text = "Cannot be divided by zero"
            }
        }
    }
}