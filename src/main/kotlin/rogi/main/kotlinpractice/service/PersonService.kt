package rogi.main.kotlinpractice.service

import org.springframework.stereotype.Service
import rogi.main.kotlinpractice.data.Person
import rogi.main.kotlinpractice.repository.PersonRepository

@Service
class PersonService (val repository: PersonRepository) {
    fun allPersons(): List<Person> {
        return repository.all()
    }

    fun findPerson(id: Int): Person? {
        return repository.all()
            .firstOrNull { person -> person.id == id }
    }

    fun createPerson(person: Person) {
        repository.insertPerson(person)
    }
}