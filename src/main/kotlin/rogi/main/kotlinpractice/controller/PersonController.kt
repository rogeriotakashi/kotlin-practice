package rogi.main.kotlinpractice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import rogi.main.kotlinpractice.data.Person
import rogi.main.kotlinpractice.service.PersonService

@RestController
class PersonController (val personService: PersonService){

    @GetMapping("/persons")
    fun persons(): List<Person> {
        return personService.allPersons()
    }

    @GetMapping("/person")
    fun person(): Person {
        return personService.findPerson()
    }
}