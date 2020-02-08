package com.ddam40.example.quicklockker

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.preference.MultiSelectListPreference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val fragment = MyPreferenceFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().replace(R.id.preferenceContent, fragment).commit()
    }

    class MyPreferenceFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.pref)

            val categoryPref = findPreference("category") as MultiSelectListPreference
            categoryPref.summary = categoryPref.values.joinToString(", ")

            categoryPref.setOnPreferenceChangeListener { preference, newValue ->
                val newValueSet =
                    newValue as? HashSet<*> ?: return@setOnPreferenceChangeListener true
                categoryPref.summary = newValue.joinToString(", ")
                true
            }

            val useLockScreenPref = findPreference("useLockScreen") as SwitchPreference
            useLockScreenPref.setOnPreferenceClickListener {
                when {
                    useLockScreenPref.isChecked -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            activity.startForegroundService(
                                Intent(
                                    activity,
                                    LockScreenService::class.java
                                )
                            )
                        } else {
                            activity.startService(Intent(activity, LockScreenService::class.java))
                        }
                    }
                    else -> activity.stopService(Intent(activity, LockScreenService::class.java))
                }
                true
            }
            if (useLockScreenPref.isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    activity.startForegroundService(Intent(activity, LockScreenService::class.java))
                } else {
                    activity.startService(Intent(activity, LockScreenService::class.java))
                }
            }
        }

    }

}
