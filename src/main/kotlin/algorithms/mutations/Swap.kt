package com.technosudo.algorithms.mutations

import com.technosudo.Data.City
import com.technosudo.algorithms.misc.Misc
import kotlin.random.Random

object Swap : Mutation {
    override fun mutate(backpacks: Set<List<City>>, chance: Double): Set<List<City>> {
        val result: MutableSet<List<City>> = mutableSetOf()
        for (backpack in backpacks) {
            val mutated = backpack.toMutableList()
            if (Misc.withChance(chance)) {
                val index1 = Random.nextInt(0, backpack.size)
                val index2 = Random.nextInt(0, backpack.size)
                mutated[index1] = backpack[index2]
                mutated[index2] = backpack[index1]
            }
            result.add(mutated)
        }
        return result
    }
}