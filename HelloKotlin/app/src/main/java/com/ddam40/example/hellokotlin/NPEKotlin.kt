package com.ddam40.example.hellokotlin

fun strLengthNonNull(str: String): Int {
    return str.length
}

fun strLengthNullable(str: String?): Int {
    //return if(str!= null) str.length else 0
    return str?.length ?: "".length
}