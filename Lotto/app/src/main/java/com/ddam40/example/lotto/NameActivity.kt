package com.ddam40.example.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ddam40.example.lotto.LottoNumberMaker.getLottoNumbersFromHash
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButton.setOnClickListener {
            if(TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))
            intent.putExtra("name", editText.text.toString())
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
