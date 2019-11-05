package com.example.android.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.android.calculadora.parser.Parser
import kotlin.math.*


class MainActivity : AppCompatActivity() {

    private var result_text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setLandcapeListeners() {
        val button_ln = findViewById<TextView>(R.id.button_ln)
        val button_exp = findViewById<TextView>(R.id.button_exp)
        val button_cos = findViewById<TextView>(R.id.button_cos)
        val button_sin = findViewById<TextView>(R.id.button_sin)
        val button_tan = findViewById<TextView>(R.id.button_tan)

        val buttons = listOf<TextView>(button_ln, button_exp,
            button_cos, button_sin, button_tan)

        for (button in buttons) {
            button.setOnClickListener {
                addOp(it)
            }
        }
    }

    private fun setListeners() {

        val button_0 = findViewById<TextView>(R.id.button_0)
        val button_1 = findViewById<TextView>(R.id.button_1)
        val button_2 = findViewById<TextView>(R.id.button_2)
        val button_3 = findViewById<TextView>(R.id.button_3)
        val button_4 = findViewById<TextView>(R.id.button_4)
        val button_5 = findViewById<TextView>(R.id.button_5)
        val button_6 = findViewById<TextView>(R.id.button_6)
        val button_7 = findViewById<TextView>(R.id.button_7)
        val button_8 = findViewById<TextView>(R.id.button_8)
        val button_9 = findViewById<TextView>(R.id.button_9)

        val button_c = findViewById<TextView>(R.id.button_c)
        val button_parg = findViewById<TextView>(R.id.button_parg)
        val button_pard = findViewById<TextView>(R.id.button_pard)
        val button_x = findViewById<TextView>(R.id.button_mult)
        val button_min = findViewById<TextView>(R.id.button_min)
        val button_div = findViewById<TextView>(R.id.button_div)
        val button_plus = findViewById<TextView>(R.id.button_plus)
        val button_eq = findViewById<TextView>(R.id.button_eq)
        val button_point = findViewById<TextView>(R.id.button_point)

        val buttons: List<TextView> = listOf(button_0, button_1, button_2, button_3, button_4, button_5,
            button_6, button_7, button_8, button_9, button_c, button_parg, button_pard, button_x,
            button_min, button_div, button_plus, button_eq, button_point)

        for (button in buttons) {
            button.setOnClickListener {
                addOp(it)
            }
        }

        if (findViewById<TextView>(R.id.button_ln) != null) {
            setLandcapeListeners()
        }
    }

    private fun addOp(view: View) {
        val result = findViewById<TextView>(R.id.result_text)
        when (view.id) {
            R.id.button_0 -> {result_text += "0"}
            R.id.button_1 -> {result_text += "1"}
            R.id.button_2 -> {result_text += "2"}
            R.id.button_3 -> {result_text += "3"}
            R.id.button_4 -> {result_text += "4"}
            R.id.button_5 -> {result_text += "5"}
            R.id.button_6 -> {result_text += "6"}
            R.id.button_7 -> {result_text += "7"}
            R.id.button_8 -> {result_text += "8"}
            R.id.button_9 -> {result_text += "9"}

            R.id.button_parg -> {result_text += " ( "}
            R.id.button_pard -> {result_text += " ) "}
            R.id.button_plus -> {result_text += " + "}
            R.id.button_min -> {result_text += " - "}
            R.id.button_mult -> {result_text += " * "}
            R.id.button_div -> {result_text += " / "}
            R.id.button_point -> {result_text += "."}

            R.id.button_ln -> {
                val temp = Parser.evaluate(result_text)
                if (temp >= 0.0) {
                    result_text = ln(temp).toString()
                }
            }
            R.id.button_exp -> {
                result_text = exp(Parser.evaluate(result_text)).toString()
            }
            R.id.button_cos -> {
                result_text = cos(Parser.evaluate(result_text)).toString()
            }
            R.id.button_sin -> {
                result_text = sin(Parser.evaluate(result_text)).toString()
            }
            R.id.button_tan -> {
                result_text = tan(Parser.evaluate(result_text)).toString()
            }

            R.id.button_eq -> {result_text = Parser.evaluate(result_text).toString()}
            R.id.button_c -> {result_text = ""}
            else -> result_text = ""
        }
        result.text = if (result_text != "") result_text else "0"
    }
}
