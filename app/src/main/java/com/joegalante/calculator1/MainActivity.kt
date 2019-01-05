package com.joegalante.calculator1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    val btn_zero = 0
//    val btn_one = 1
//    val btn_two = 2
//    val btn_three = 3
//    val btn_four = 4
//    val btn_five = 5
//    val btn_six = 6
//    val btn_seven = 7
//    val btn_eight = 8
//    val btn_nine = 9
//    val btn_equals = '='
//    val btn_decimal = '.'
    var result_string = ""
    var exp1 = ""
    var expression2 = ""
    var operation = ""
    var prevOperation = ""
    var expList = ArrayList<String>()
    var currentResult = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_0.setOnClickListener {
            if(result_string == ""){
                Toast.makeText(this, "Expressions cannot start with 0.", Toast.LENGTH_SHORT).show()
            }
            else {
                result_string += button_0.text.toString()
                result_editText.text = result_string
            }
        }
        button_1.setOnClickListener {
            result_string += button_1.text.toString()
            result_editText.text = result_string
        }
        button_2.setOnClickListener {
            result_string += button_2.text.toString()
            result_editText.text = result_string
        }
        button_3.setOnClickListener {
            result_string += button_3.text.toString()
            result_editText.text = result_string
        }
        button_4.setOnClickListener {
            result_string += button_4.text.toString()
            result_editText.text = result_string
        }
        button_5.setOnClickListener {
            result_string += button_5.text.toString()
            result_editText.text = result_string
        }
        button_6.setOnClickListener {
            result_string += button_6.text.toString()
            result_editText.text = result_string
        }
        button_7.setOnClickListener {
            result_string += button_7.text.toString()
            result_editText.text = result_string
        }
        button_8.setOnClickListener {
            result_string += button_8.text.toString()
            result_editText.text = result_string
        }
        button_9.setOnClickListener {
            result_string += button_9.text.toString()
            result_editText.text = result_string
        }


        fun performOperation(operation: String, exp1: Int, exp2: Int): Int {
            Log.d("Main", "Performing Operation: " + operation)
            Log.d("Main", "exp1: " + exp1.toString())
            Log.d("Main", "exp2: " + exp2.toString())
            if(operation == "+") {
                var tempResult = exp1 + exp2
                Log.d("Main", "tempresult: " + tempResult.toString())
                return exp1 + exp2
            }
            else if(operation == "-") {
                return exp1 - exp2
            }
            else if(operation == "x") {
                Log.d("Main", "Performing *")
                return exp1 * exp2
            }
            else {
                if(exp1 != 0) {
                    return exp1 / exp2
                }
                else {
                    return -1
                }
            }

        }

        button_division.setOnClickListener {
            if(!result_editText.text.toString().equals("ERROR")) {
                prevOperation = operation
                operation = button_division.text.toString()
                if (!expList.isEmpty() && result_string.toInt() != 0) {
                    currentResult = performOperation(prevOperation, expList.last().toInt(), result_string.toInt())
                    //                currentResult = expList.last().toInt() / result_string.toInt()
                    if (currentResult == -1) {
                        Log.d("Main", "curr result: $currentResult")
                        result_string = "ERROR"
                    } else {
                        result_string = currentResult.toString()
                    }
                    result_editText.text = result_string
                } else
                    Toast.makeText(this, "Cannot divide by 0.", Toast.LENGTH_SHORT).show()
                expList.add(result_string)
                result_string = ""
            }
        }
        button_multiplication.setOnClickListener {
            if(!result_editText.text.toString().equals("ERROR")) {
                prevOperation = operation
                operation = button_multiplication.text.toString()
                if (!expList.isEmpty()) {
                    currentResult = performOperation(prevOperation, expList.last().toInt(), result_string.toInt())
                    //                currentResult = expList.last().toInt() * result_string.toInt()
                    Log.d("Main", "curr result: $currentResult")
                    result_string = currentResult.toString()
                    result_editText.text = result_string
                }
                expList.add(result_string)
                result_string = ""
            }
        }
        button_subtraction.setOnClickListener {
            if(!result_editText.text.toString().equals("ERROR")) {
                prevOperation = operation
                operation = button_subtraction.text.toString()
                if (!expList.isEmpty()) {
                    currentResult = performOperation(prevOperation, expList.last().toInt(), result_string.toInt())
                    //                currentResult = expList.last().toInt() - result_string.toInt()
                    Log.d("Main", "curr result: $currentResult")
                    result_string = currentResult.toString()
                    result_editText.text = result_string
                }
                expList.add(result_string)
                result_string = ""
            }
        }
        button_addition.setOnClickListener {
            if(!result_editText.text.toString().equals("ERROR")) {
                prevOperation = operation
                operation = button_addition.text.toString()
                if (!expList.isEmpty()) {
                    currentResult = performOperation(prevOperation, expList.last().toInt(), result_string.toInt())
                    //                currentResult = expList.last().toInt() + result_string.toInt()
                    Log.d("Main", "curr result: $currentResult")
                    result_string = currentResult.toString()
                    result_editText.text = result_string
                }
                expList.add(result_string)
                result_string = ""
            }
        }
        button_equals.setOnClickListener {
            Log.d("Main", "expList: " + expList.last())
            Log.d("Main", "resultString: " + result_string)
            if(!expList.isEmpty() && result_string != "") {
                var result = performOperation(operation, expList.last().toInt(), result_string.toInt())
                result_editText.text = result.toString()
            }
            else{
                result_editText.text = "ERROR"
            }
            Log.d("Main", "textView: " + result_editText.text.toString())
        }
        button_clear.setOnClickListener {
            operation = ""
            prevOperation = ""
            result_string = ""
            expList.clear()
            result_editText.text = result_string
        }
        button_back.setOnClickListener {
            result_string = result_string.dropLast(1)
            Log.d("Main", "dropLast: " + result_string)
            result_editText.text = result_string
        }

    }
}
