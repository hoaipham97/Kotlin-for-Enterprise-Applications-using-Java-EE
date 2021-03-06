package org.rao.kotlin.intro

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

private suspend fun game1(): String {
    delay(1000)
    return "game1"
}
private suspend fun game2(): String {
    delay(2000)
    return "game2"
}

fun main(args: Array<String>) {
    println("Inside main")

    launch(CommonPool) {
        val one = async(CommonPool){
            game1()
        }
        val two = async(CommonPool){
            game2()
        }
        println("Game ----- " + one.await()+": "+two.await())
    }
    Thread.sleep(4000)
}
