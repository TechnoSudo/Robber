package com.technosudo.algorithms.mutations

import com.technosudo.Data.City
import com.technosudo.Solution
import com.technosudo.algorithms.misc.Misc
import kotlin.random.Random

object ItemMutation {
    fun mutate(
        cities: Set<City>,
        backpacks: Set<List<City>>,
        chance: Double,
    ): Set<List<City>> {
        return backpacks.map { road ->
            if (!Misc.withChance(chance))
                road
            if (Misc.withChance(0.5)) {
                var cityToChange = cities.random()
                var itemToChange = cityToChange.items.random()
                var totalWeight = road.sumOf { city -> city.items.sumOf { item -> item.weight } }
                if (!(totalWeight + itemToChange.weight > Solution.WEIGHT_MAX)) {
                    road.map { city ->
                        if (city == cityToChange) {
                            city.copy(items = city.items.filter { item ->
                                item == itemToChange
                            }.toSet())
                        }
                        city
                    }
                }
            }
            val randomCity = road.random()
            road.map { city ->
                if (city == randomCity) {
                    val randomItem = city.items.randomOrNull()
                    city.copy(items = city.items.filter { item ->
                        item != randomItem
                    }.toSet())
                }
                city
            }
        }.toSet()
    }
}