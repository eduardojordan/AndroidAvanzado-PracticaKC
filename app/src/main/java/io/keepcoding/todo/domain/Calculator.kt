package io.keepcoding.todo.domain

open class Calculator {

    fun par(x: Int): Boolean {
        return obtenerResto(x, 2) == 0
    }

    fun obtenerResto(num: Int, by: Int): Int = num % by

}