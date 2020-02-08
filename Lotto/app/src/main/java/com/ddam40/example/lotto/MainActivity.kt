package com.ddam40.example.lotto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ddam40.example.lotto.LottoNumberMaker.getShuffleLottoNumbers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))
            startActivity(intent)
        }

        constellationCard.setOnClickListener {
            startActivity(Intent( this, ConstellationActivity::class.java))
        }

        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }

}
