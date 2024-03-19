package com.technosudo.algorithms.evaluation

import com.technosudo.Data.City
import com.technosudo.Solution

object Evaluation {
    fun evaluate(
        backpacks: Set<List<City>>,
        distances: Map<Set<Long>, Double>
    ): Set<Pair<List<City>, Double>> {

        val evaluation: MutableSet<Pair<List<City>, Double>> = mutableSetOf()
        for (backpack in backpacks) {

            var totalValue = 0.0
            for (city in backpack)
                for (item in city.items)
                    totalValue += item.value

            val road: Array<City> = backpack.toTypedArray() + backpack.first()
            var totalWeight = 0.0
            var totalTime = 0.0
            road.forEachIndexed { index, city ->
                if (index == backpack.size)
                    return@forEachIndexed
                val distance = distances[setOf(
                    city.index,
                    road[index + 1].index
                )]
                totalWeight += city.items.sumOf { item -> item.weight }
                totalTime += distance?.let { time(totalWeight, it) } ?: 0.0
            }

            val result = totalValue - totalTime

            evaluation.add(Pair(
                backpack,
                result
            ))
        }
        return evaluation
    }

    private fun time(weight: Double, distance: Double): Double {
        return Solution.V_MAX - weight * (Solution.V_MAX - Solution.V_MIN) / Solution.WEIGHT_MAX
    }
}