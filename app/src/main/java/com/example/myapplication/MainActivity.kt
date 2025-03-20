//package com.example.myapplication
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var totalAmount: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAmount = findViewById<EditText>(R.id.etn)
        val radioGroup = findViewById<RadioGroup>(R.id.rg)
        val radioButtonExpense = findViewById<RadioButton>(R.id.rb1)
        val radioButtonIncome = findViewById<RadioButton>(R.id.rb2)
        val buttonAdd = findViewById<Button>(R.id.button)
        val textViewTotal = findViewById<TextView>(R.id.tv5)

        buttonAdd.setOnClickListener {
            val inputText = editTextAmount.text.toString()
            if (inputText.isNotEmpty()) {
                val amount = inputText.toDouble()

                if (radioButtonExpense.isChecked) {
                    totalAmount -= amount  // 支出
                } else if (radioButtonIncome.isChecked) {
                    totalAmount += amount  // 收入
                }

                textViewTotal.text = totalAmount.toString()

                // 清空輸入欄位
                editTextAmount.text.clear()
            } else {
                Toast.makeText(this, "請輸入金額", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
