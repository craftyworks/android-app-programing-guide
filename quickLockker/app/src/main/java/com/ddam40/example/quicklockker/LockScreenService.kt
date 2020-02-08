package com.ddam40.example.quicklockker

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class LockScreenService : Service() {
    var receiver: ScreenOffReceiver? = null

    private val ANDROID_CHANNEL_ID = "com.ddam40.example.quicklockker"
    private val NOTIFICATION_ID = 9999

    override fun onCreate() {
        super.onCreate()

        if (receiver == null) {
            receiver = ScreenOffReceiver()
            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(receiver, filter)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (intent != null) {
            if (intent.action == null) {
                if (receiver == null) {
                    receiver = ScreenOffReceiver()
                    val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                    registerReceiver(receiver, filter)
                }
            }
        }
        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        if(receiver != null) {
            unregisterReceiver(receiver)
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
