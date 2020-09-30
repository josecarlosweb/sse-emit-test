package com.example.demo.data

import org.ajbrown.namemachine.Gender
import org.ajbrown.namemachine.NameGenerator
import java.io.Serializable
import java.util.*

data class People(
        val id: String? = UUID.randomUUID().toString()
        , val age: Int? = (Math.random() * (80 - 18) + 18).toInt()
        , val name: String
        , val gender: Gender
): Serializable

fun getPeople(): List<People> {
    val generator = NameGenerator()
    val names = generator.generateNames(1000)
    return names.map {name ->
        val fullName = "${name.firstName} ${name.lastName}"
        People(name = fullName, gender = name.gender)
    }
}