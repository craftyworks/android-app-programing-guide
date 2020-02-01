package com.ddam40.example.hellokotlin

import java.io.InputStreamReader
import java.net.URL

class Person(val name: String, var age: Int) {
    var nickname: String = ""
        set(value) {
            field = value.toLowerCase()
        }
    val httpText by lazy {
        println("lazy int start")
        InputStreamReader(URL("https://www.naver.com").openConnection().getInputStream()).readText()
    }
}