package rogi.main.kotlinpractice.service

import org.springframework.stereotype.Service
import rogi.main.kotlinpractice.data.Person

@Service
class PersonService {
    fun allPersons(): List<Person> {
        return listOf(
            Person(1, "Person A", 18, "User"),
            Person(2, "Person B", 19, "User"),
            Person(3, "Person C", 20, "User")
        )
    }

    fun findPerson(): Person {
        return Person(1, "Person A", 18, "User")
    }
}