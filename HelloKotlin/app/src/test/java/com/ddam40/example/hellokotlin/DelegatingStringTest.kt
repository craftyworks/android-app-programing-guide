package com.ddam40.example.hellokotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DelegatingStringTest {
    var nickname by DelegatingString()

    @Test
    fun testDelegatingString() {
        var str: DelegatingString = DelegatingString()
        str.text = "hello"

        assertThat(str.text).isEqualTo("hello")

        nickname = "Hello"
        assertThat(nickname).isEqualTo("HELLO")
    }
}