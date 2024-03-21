package com.technosudo.algorithms.crossovers

import com.technosudo.Data.City

interface Crossover {
    fun crossover(
        backpacks: Set<List<City>>,
        chance: Double,
        num: Long
    ): Set<List<City>>
}