package com.ddam40.example.hellokotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class KotlinTest {
    @Test
    fun test1() {
        assertThat(333).isEqualTo(333)
    }

    @Test
    fun testPersonGetter() {
        var person: Person = Person("james", 30)

        assertThat(person.name).isEqualTo("james")
        assertThat(person.age).isEqualTo(30)

        person.age = 20
        assertThat(person.age).isEqualTo(20)

        person.nickname = "James Dean"
        assertThat(person.nickname).isEqualTo("james dean")

        var mutableList = DelegatingArrayList<String>()
        mutableList.add("Hello")

        assertThat(mutableList.size).isEqualTo(1)
    }

    @Test
    fun testPersonHttpText() {
        val person = Person("Hello", age = 4)
        println("not init")
        assertThat(person.httpText).isNotNull()
    }

    @Test
    fun testAnimal() {
        val animal = Animal(mutableMapOf("name" to "cat", "age" to 5))
        assertThat(animal.name).isEqualTo("cat")
        assertThat(animal.age).isEqualTo(5)

        animal.age = 21
        animal.name = "dog"

        assertThat(animal.map["name"]).isEqualTo("dog")
        assertThat(animal.map["age"]).isEqualTo(21)
    }

    @Test
    fun testFruit() {
        val fruit1 = Fruit("바나나", "바나나 길어")
        val fruit2 = Fruit("바나나", "바나나 길어")

        println(fruit1)
        println(fruit2)

        assertThat(fruit1).isEqualTo(fruit2)
        assertThat(fruit1.hashCode()).isEqualTo(fruit2.hashCode())
    }

}