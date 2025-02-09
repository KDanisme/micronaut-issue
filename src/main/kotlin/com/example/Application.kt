package com.example

import io.micronaut.runtime.Micronaut

class Application

fun main() {
    Micronaut.build()
        .mainClass(Application::class.java)
        .start()
}
