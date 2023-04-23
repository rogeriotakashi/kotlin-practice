package rogi.main.kotlinpractice.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestClientException
import rogi.main.kotlinpractice.KotlinPracticeApplication
import rogi.main.kotlinpractice.data.Person

@SpringBootTest(classes = arrayOf(KotlinPracticeApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun shouldReturnAllPersons() {
        val result = testRestTemplate.getForEntity("/persons", List::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).hasSize(9)
    }

    @Test
    fun shouldReturnPerson(){
        val result = testRestTemplate.getForEntity("/person/1", Person::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Person(1, "Person A", 18, "User"))
    }

    @Test
    fun shouldReturnNotFoundPerson(){
        val result = testRestTemplate.getForEntity("/person/54987", Person::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Person(id = 9999, name = "Not found", age = 0, role = "NOT_FOUND"))
    }

    @Test
    fun shouldFindPersonByNameAndAge(){
        val result = testRestTemplate.getForEntity("/person?name=Person A&age=18", Person::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Person(1, "Person A", 18, "User"))
    }

    @Test
    fun shouldThrowExceptionWhenFindPersonByNameAndAge(){
        assertThrows<RestClientException>
        { testRestTemplate.getForEntity("/person?name=Inexistent&age=18", Person::class.java) }
    }

    @Test
    fun shouldCreatePerson(){
        val newPerson = Person(9999, "New Person", 99, "User")
        val result = testRestTemplate.postForEntity("/person", newPerson, HttpStatus::class.java)
        val result2 = testRestTemplate.getForEntity("/person/9999", Person::class.java)

        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result2?.body).isEqualTo(Person(9999, "New Person", 99, "User"))
    }

}