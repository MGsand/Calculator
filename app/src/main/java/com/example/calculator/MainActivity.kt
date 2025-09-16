package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        findViewById<TextView>(R.id.btn_0).setOnClickListener { setText("0") }
        findViewById<TextView>(R.id.btn_1).setOnClickListener { setText("1") }
        findViewById<TextView>(R.id.btn_2).setOnClickListener { setText("2") }
        findViewById<TextView>(R.id.btn_3).setOnClickListener { setText("3") }
        findViewById<TextView>(R.id.btn_4).setOnClickListener { setText("4") }
        findViewById<TextView>(R.id.btn_5).setOnClickListener { setText("5") }
        findViewById<TextView>(R.id.btn_6).setOnClickListener { setText("6") }
        findViewById<TextView>(R.id.btn_7).setOnClickListener { setText("7") }
        findViewById<TextView>(R.id.btn_8).setOnClickListener { setText("8") }
        findViewById<TextView>(R.id.btn_9).setOnClickListener { setText("9") }

        findViewById<TextView>(R.id.btn_minus).setOnClickListener { setText("-") }
        findViewById<TextView>(R.id.btn_plus).setOnClickListener { setText("+") }
        findViewById<TextView>(R.id.btn_multiply).setOnClickListener { setText("*") }
        findViewById<TextView>(R.id.btn_divide).setOnClickListener { setText("/") }
        findViewById<TextView>(R.id.btn_br1).setOnClickListener { setText("(") }
        findViewById<TextView>(R.id.btn_br2).setOnClickListener { setText(")") }

        findViewById<TextView>(R.id.btn_clear).setOnClickListener {
            findViewById<TextView>(R.id.math_operation).text = ""
            findViewById<TextView>(R.id.result_text).text = ""
        }

        findViewById<TextView>(R.id.btn_delite).setOnClickListener {
            val str = findViewById<TextView>(R.id.math_operation).text.toString()
            if(str.isNotEmpty()){
                findViewById<TextView>(R.id.math_operation).text = str.substring(0, str.length - 1)

                findViewById<TextView>(R.id.result_text).text = ""
            }
        }

        findViewById<TextView>(R.id.btn_result).setOnClickListener {
            try{
                val ex = ExpressionBuilder(findViewById<TextView>(R.id.math_operation).text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()){
                    findViewById<TextView>(R.id.result_text).text = longRes.toString()
                }else
                    findViewById<TextView>(R.id.result_text).text = result.toString()

            } catch (e:Exception ) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }

    }

    fun setText(str: String){
        findViewById<TextView>(R.id.math_operation).append(str)
    }



}