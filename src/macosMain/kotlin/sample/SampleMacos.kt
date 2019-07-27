package sample

import kotlinx.coroutines.*

fun hello(): String = "Hello, Kotlin/Native!"

fun main() = runBlocking {
    hello()
        .map {
            async {
                delay(1000)
                it
            }
        }
        .awaitAll()
        .joinToString("")
        .let {
            println(it)
        }
}
