package com.ddam40.example.hellokotlin

import kotlin.reflect.KProperty

class DelegatingString {
    var text = ""


    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return text
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        text = value.toUpperCase()
        println("$value => ${text}")
    }
}