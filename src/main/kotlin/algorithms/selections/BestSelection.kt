package com.technosudo.algorithms.selections

import com.technosudo.Data.City
import java.util.*

object BestSelection : Selection {
    override fun select(
        evaluation: Set<Pair<List<City>, Double>>,
        num: Long
    ): Set<List<City>> {
        val ordered = evaluation.toSortedSet(compareByDescending<Pair<List<City>, Double>> { it.second })
        return ordered.take(num.toInt()).map { it.first }.toSet()
    }
}