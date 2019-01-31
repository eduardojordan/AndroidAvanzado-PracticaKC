package io.keepcoding.todo.util

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Event<Unit>>.call() {
    value = Event(Unit)
}

fun <T> MutableLiveData<Event<T>>.call(input: T) {
    value = Event(input)
}