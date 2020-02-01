package com.ddam40.example.hellokotlin

import android.app.Application
import android.content.Context

class MainApplication : Application() {
    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }
}
