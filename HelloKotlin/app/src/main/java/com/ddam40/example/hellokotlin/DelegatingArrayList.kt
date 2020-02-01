package com.ddam40.example.hellokotlin

class DelegatingArrayList<T>(val innerList: MutableCollection<T> = mutableListOf()) : MutableCollection<T> by innerList {
}