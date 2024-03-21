package com.technosudo.algorithms.crossovers

import com.technosudo.Data.City
import com.technosudo.Data.Item
import com.technosudo.algorithms.misc.Misc
import kotlin.random.Random

object OrderedCrossover : Crossover {
    override fun crossover(
        backpacks: Set<List<City>>,
        chance: Double,
        num: Long
    ): Set<List<City>> {
        val result: MutableSet<List<City>> = mutableSetOf()
        for (i in 0..num) {
            val parent1 = backpacks.random()
            val parent2 = backpacks.random()

            val crossItems: MutableMap<Long, MutableMap<Item, Int>> = mutableMapOf()
            for (parent in listOf(parent1, parent2)) {
                for (city in parent) {
                    if (!crossItems.contains(city.index))
                        crossItems[city.index] = mutableMapOf()
                    val cityItems = crossItems[city.index]!!
                    for (item in city.items) {
                        if (cityItems.contains(item))
                            cityItems[item] = 2
                        else cityItems[item] = 1
                    }
                }
            }

            val slicePoint = Random.nextInt(0, parent1.size-1)
            val slicePointSec = Random.nextInt(slicePoint, parent1.size)

            val parent1Slice = parent1.subList(slicePoint, slicePointSec)
            val rest = parent2.filter { city -> !parent1Slice.contains(city) }

            val startingSlice = rest.subList(0, slicePoint)
            val endingSlice = rest.subList(slicePoint, rest.size)
            
            var child = startingSlice + parent1Slice + endingSlice
            child = child.map { city -> city.copy(items =
                crossItems[city.index]?.filter { (item, chance) ->
                    if (chance == 1)
                        Misc.withChance(0.5)
                    else true
                }?.map { it.key }?.toSet() ?: emptySet()
            ) }

            result.add(child)
        }
        return result
    }
}