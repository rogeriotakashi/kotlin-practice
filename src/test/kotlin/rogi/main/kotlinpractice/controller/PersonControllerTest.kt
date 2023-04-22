package rogi.main.kotlinpractice.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
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
        assertThat(result?.body).hasSize(3)
    }

    @Test
    fun shouldReturnPerson(){
        val result = testRestTemplate.getForEntity("/person/1", Person::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Person(1, "Person A", 18, "User"))
    }

}