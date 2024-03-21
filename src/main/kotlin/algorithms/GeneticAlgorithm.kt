package com.technosudo.Algorithms

import com.technosudo.Data.City
import com.technosudo.algorithms.Algorithm
import com.technosudo.algorithms.crossovers.OrderedCrossover
import com.technosudo.algorithms.evaluation.Evaluation
import com.technosudo.algorithms.mutations.ItemMutation
import com.technosudo.algorithms.mutations.Swap
import com.technosudo.algorithms.selections.BestSelection

class GeneticAlgorithm (
    val cities: Set<City>,
    val distances: Map<Set<Long>, Double>,
    val maxGen: Long,
    val crossoverChance: Double,
    val roadMutationChance: Double,
    val itemMutationChance: Double,
    val candidateNum: Long,
    val startingOrder: List<City>,
    val verbose: Boolean = false,
) : Algorithm {
    override fun run() {

        val best: MutableList<Double> = mutableListOf()
        val average: MutableList<Double> = mutableListOf()
        val worst: MutableList<Double> = mutableListOf()

        val firstPopulation: MutableSet<List<City>> = mutableSetOf()
        for (i in 0..<candidateNum)
            firstPopulation.add(startingOrder)
        var history: MutableList<Set<Pair<List<City>, Double>>> = mutableListOf(Evaluation.evaluate(firstPopulation, distances))

        for (gen in 0..<maxGen) {
            var population = BestSelection.select(history.last(), 3)
            population = OrderedCrossover.crossover(
                backpacks = population,
                chance = crossoverChance,
                num = candidateNum
            )
            population = Swap.mutate(population, roadMutationChance)
            population = ItemMutation.mutate(
                cities = cities,
                backpacks = population,
                chance = itemMutationChance
            )
            history.add(Evaluation.evaluate(population, distances))
            println(history.last().maxBy { it.second }.second)
        }
        return
    }
}