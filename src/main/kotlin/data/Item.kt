package com.technosudo.Data

data class Item(
    val value: Double,
    val weight: Double
) {
    fun effectivity(): Double {
        return value / weight
    }
}
