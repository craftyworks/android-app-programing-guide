package com.ddam40.example.hellokotlin

val sum = {x:Int, y:Int -> x+y}

fun sum2(x:Int, y:Int): Int {
    println("sum($x, $y)")
    return x + y
}
