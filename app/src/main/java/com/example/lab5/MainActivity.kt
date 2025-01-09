package com.example.laba5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab5.MainActivity2
import com.example.lab5.R

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
        val etHours = findViewById<EditText>(R.id.etHours)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnOk = findViewById<Button>(R.id.btnOk)

        btnOk.setOnClickListener {
            val hoursStr = etHours.text.toString()
            if (hoursStr.isEmpty()) {
                Toast.makeText(this, "Введите количество часов", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hours = hoursStr.toInt()
            var costPerHour = 2000

            when (radioGroup.checkedRadioButtonId) {
                R.id.rbCar -> costPerHour = 2000
                R.id.rbMinivan -> costPerHour = 2500
                R.id.rbBus -> costPerHour = 3500
            }

            val totalCost = hours * costPerHour

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("totalCost", totalCost)
            startActivity(intent)
        }
    }
}