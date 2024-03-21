package com.technosudo.algorithms.mutations

import com.technosudo.Data.City

interface RoadMutation {
    fun mutate(
        backpacks: Set<List<City>>,
        chance: Double
    ): Set<List<City>>
}