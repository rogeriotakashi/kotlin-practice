package rogi.main.kotlinpractice.concepts

fun main() {
    val person = Person("Rogerio")
    person.setNickname("Rogi")
    println(person.printNickname())
}

data class Person(private val name: String) {
    private lateinit var nickname: String

    fun printNickname(): String = "My name is $name, but you can call me $nickname"

    fun setNickname(nickname: String) {
        this.nickname = nickname
    }
}