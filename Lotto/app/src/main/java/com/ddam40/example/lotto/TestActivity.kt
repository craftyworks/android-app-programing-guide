package com.ddam40.example.lotto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        button.setOnClickListener {
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
            startActivity(intent)
        }
    }
}
