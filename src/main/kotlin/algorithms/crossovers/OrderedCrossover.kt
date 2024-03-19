package com.technosudo.algorithms.crossovers

import com.technosudo.Data.City
import kotlin.random.Random

object OrderedCrossover : Crossover {
    override fun crossover(
        cities: Set<City>,
        backpacks: Set<List<City>>,
        chance: Double,
        num: Long
    ): Set<List<City>> {
        val result: MutableSet<List<City>> = mutableSetOf()
        for (i in 0..num) {
            val parent1 = backpacks.random()
            val parent2 = backpacks.random()

            val slicePoint = Random.nextInt(0, parent1.size-1)
            val slicePointSec = Random.nextInt(slicePoint, parent1.size)

            val parent1Slice = parent1.subList(slicePoint, slicePointSec)
            val rest = parent2.filter { city -> !parent1Slice.contains(city) }

            val startingSlice = rest.subList(0, slicePoint)
            val endingSlice = rest.subList(slicePoint, rest.size)

            result.add(startingSlice + parent1Slice + endingSlice)
        }
        return result
    }
}