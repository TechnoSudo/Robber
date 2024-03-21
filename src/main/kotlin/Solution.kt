package com.technosudo

import com.technosudo.Algorithms.GeneticAlgorithm
import com.technosudo.Data.City
import com.technosudo.Data.Item

object Solution {
    fun run() {
        val cities = setOf(
            City(0, setOf(Item(40.0, 1.0))),
            City(1, setOf(Item(1.0, 1.0), Item(1.0, 1.0))),
            City(2, setOf(Item(1.0, 1.0), Item(1.0, 1.0), Item(1.0, 1.0)))
        )
        val startingOrder = listOf(
            City(0, setOf(Item(1.0, 1.0))),
            City(1, setOf()),
            City(2, setOf(Item(1.0, 1.0), Item(1.0, 1.0)))
        )
        val distances = mapOf(
            Pair(setOf(0L,1L), 1.0),
            Pair(setOf(0L,2L), 2.0),
            Pair(setOf(1L,2L), 8.0)
        )

        val geneticAlgorithm = GeneticAlgorithm(
            cities = cities,
            distances = distances,
            maxGen = 100,
            crossoverChance = 1.0,
            roadMutationChance = 0.1,
            itemMutationChance = 0.1,
            candidateNum = 100,
            startingOrder = startingOrder
        )

        geneticAlgorithm.run()
    }

    const val V_MAX = 6
    const val V_MIN = 3
    const val WEIGHT_MAX = 20
}