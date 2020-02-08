package com.ddam40.example.quicklockker

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ScreenOffExActivity : AppCompatActivity() {

    var screenOffReceiver: ScreenOffReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_off_ex)

        if(screenOffReceiver == null) {
            screenOffReceiver = ScreenOffReceiver()
            val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(screenOffReceiver, intentFilter)
        }
    }
}
