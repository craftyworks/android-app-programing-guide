package com.ddam40.example.hellokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_view_binding.*

class BmiKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_view_binding)

        bmiButton.setOnClickListener {
            val tall = tallField.text.toString().toDouble()
            val weight = weightField.text.toString().toDouble()

            val bmi = weight / Math.pow(tall / 100, 2.0)

            resultLabel.text = "키: ${tallField.text}, 체중: ${weightField.text}, BMI: $bmi"
        }
    }
}
