package com.ddam40.example.hellokotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJava.setOnClickListener {
            startActivity(Intent(this@MainActivity, BmiJavaActivity::class.java))
        }

        btnKotlin.setOnClickListener {
            startActivity(Intent(this@MainActivity, BmiKotlinActivity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent( this@MainActivity, VariableJavaActivity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent( this@MainActivity, VariableKotlinActivity::class.java))
        }

        button5.setOnClickListener {
            startActivity(Intent( this@MainActivity, ControlJavaActivity::class.java))
        }

        button6.setOnClickListener {
            startActivity(Intent( this@MainActivity, ControlKotlinActivity::class.java))
        }
    }
}
