package rogi.main.kotlinpractice.repository

import org.springframework.stereotype.Repository
import rogi.main.kotlinpractice.data.Person

@Repository
class PersonRepository {

    var persons = mutableListOf(
        Person(1, "Person A", 18, "User"),
        Person(2, "Person B", 19, "User"),
        Person(3, "Person C", 20, "User"),
        Person(4, "Person D", 18, "User"),
        Person(5, "Person E", 50, "User"),
        Person(6, "Person F", 80, "User"),
        Person(7, "Person G", 90, "User"),
        Person(8, "Person H", 40, "User"),
        Person(9, "Person I", 35, "User")
    )

    fun all(): List<Person> {
        return persons
    }

    fun insertPerson(person: Person) {
        persons.add(person)
    }
}