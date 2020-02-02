package com.ddam40.example.lotto

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        Toast.makeText(applicationContext,"ResultActivity", Toast.LENGTH_SHORT).show()
    }
}
