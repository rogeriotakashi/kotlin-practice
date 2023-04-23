package rogi.main.kotlinpractice.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import rogi.main.kotlinpractice.concepts.toSpecialToString
import rogi.main.kotlinpractice.data.Person

class ExtensionTests {

    @Test
    fun personToSpecialToStringTest() {
        val person = Person(1, "Person name", 25, "User")
        assertThat(person.toSpecialToString()).isEqualTo("Special toString for Person name")
    }
}