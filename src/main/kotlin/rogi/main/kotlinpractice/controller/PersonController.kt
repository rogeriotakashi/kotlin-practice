package rogi.main.kotlinpractice.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import rogi.main.kotlinpractice.data.Person
import rogi.main.kotlinpractice.service.PersonService

@RestController
class PersonController (val personService: PersonService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/persons")
    fun persons(): List<Person> {
        logger.info("All persons called")
        return personService.allPersons()
    }

    @GetMapping("/person/{id}")
    fun person(@PathVariable("id") id: String): Person {
        logger.info("Find person called for id {}", id)
        return personService.findPerson()
    }
}