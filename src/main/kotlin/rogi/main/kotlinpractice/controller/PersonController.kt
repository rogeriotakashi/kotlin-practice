package rogi.main.kotlinpractice.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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
    fun person(@PathVariable("id") id: Int): Person {
        logger.info("Find person called for id {}", id)
        return personService.findPerson(id) ?: run {
            logger.info("Person not found!")
            Person(id = 9999, name = "Not found", age = 0, role = "NOT_FOUND")
        }
    }

    @GetMapping("/person")
    fun byNameAndAge(@RequestParam("name") name: String, @RequestParam("age") age: Int): Person? {
        logger.info("Find person named as {} with age {}", name, age)
        return personService.findPersonByNameAndAge(name, age)
    }

    @PostMapping("/person")
    fun createPerson(@RequestBody person: Person): HttpStatus {
        logger.info("Creating new person named as {}", person.name)
        personService.createPerson(person)
        return HttpStatus.OK
    }
}