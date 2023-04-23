package rogi.main.kotlinpractice.concepts

import rogi.main.kotlinpractice.data.Person

fun Person.toSpecialToString() : String {
    return "Special toString for " + this.name
}