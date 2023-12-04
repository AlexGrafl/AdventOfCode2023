package dev.alexgrafl.puzzles

import dev.alexgrafl.StarPuzzle

const val GREENS_MAX = 13
const val REDS_MAX = 12
const val BLUES_MAX = 14

/**
 * https://adventofcode.com/2023/day/2
 * Result:
 */
class Day_2_1 : StarPuzzle() {

    override val displayName = "Day 2 Part 1"
    override val inputFile = "day_2_1"

    override fun solve(inputLines: List<String>): String {
        return inputLines.fold(0) { acc, line ->
            val splitLine = line.split(":")
            val gameId = splitLine[0].substring(5)
            val sets = splitLine[1].trim().split(";")
            var isPossible = true

            sets.forEach { set ->
                set.trim().split(",").forEach {
                    val splitNumber = it.trim().split(" ")
                    val number = splitNumber.first().toInt()
                    val type = splitNumber.last()
                    when(type) {
                        "blue" -> if(number > BLUES_MAX) isPossible = false
                        "green" -> if(number > GREENS_MAX) isPossible = false
                        "red" -> if(number > REDS_MAX) isPossible = false
                        else -> throw IllegalArgumentException("Unsupported type: $type")
                    }
                }
            }

            acc + if(isPossible) gameId.toInt() else 0
        }.toString()
    }
}