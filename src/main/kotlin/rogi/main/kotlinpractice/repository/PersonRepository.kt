package rogi.main.kotlinpractice.repository

import org.springframework.stereotype.Repository
import rogi.main.kotlinpractice.data.Person

@Repository
class PersonRepository {

    fun all(): List<Person> {
        return listOf(
            Person(1, "Person A", 18, "User"),
            Person(2, "Person B", 19, "User"),
            Person(3, "Person C", 20, "User")
        )
    }
}