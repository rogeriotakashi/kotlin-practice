package rogi.main.kotlinpractice.service

import org.springframework.stereotype.Service
import rogi.main.kotlinpractice.data.Person

@Service
class PersonService {
    fun allPersons(): List<Person> {
        return listOf(
            Person("Person A", 18, "User"),
            Person("Person B", 19, "User"),
            Person("Person C", 20, "User")
        )
    }

    fun findPerson(): Person {
        return Person("Person A", 18, "User")
    }
}