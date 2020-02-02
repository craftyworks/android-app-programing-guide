package com.ddam40.example.lotto

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConstellationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        Toast.makeText(applicationContext, "ConstellationActivity", Toast.LENGTH_SHORT).show()
    }
}
