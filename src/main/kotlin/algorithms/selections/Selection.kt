package com.technosudo.algorithms.selections

import com.technosudo.Data.City

interface Selection {
    fun select(
        evaluation: Set<Pair<List<City>, Double>>,
        num: Long
    ): Set<List<City>>
}