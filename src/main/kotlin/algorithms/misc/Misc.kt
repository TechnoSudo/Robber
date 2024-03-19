package com.technosudo.algorithms.misc

import kotlin.random.Random

object Misc {
    fun withChance(chance: Double): Boolean {
        val randomValue = Random.nextDouble(0.0, 1.0)
        return randomValue <= chance
    }
}