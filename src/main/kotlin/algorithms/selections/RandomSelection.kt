package com.technosudo.algorithms.selections

import com.technosudo.Data.City

object RandomSelection : Selection {
    override fun select(
        evaluation: Set<Pair<List<City>, Double>>,
        num: Long
    ): Set<List<City>> {
//        return backpacks.shuffled().subList(0, num.toInt())
        TODO()
    }
}