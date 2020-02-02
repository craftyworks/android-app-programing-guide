package com.ddam40.example.lotto

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        Toast.makeText(applicationContext,"NameActivity", Toast.LENGTH_SHORT).show()
    }
}
