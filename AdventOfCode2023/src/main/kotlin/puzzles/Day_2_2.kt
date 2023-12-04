package dev.alexgrafl.puzzles

import dev.alexgrafl.StarPuzzle
import java.lang.Integer.max

/**
 * https://adventofcode.com/2023/day/2
 * Result:
 */
class Day_2_2 : StarPuzzle() {

    override val displayName = "Day 2 Part 2"
    override val inputFile = "day_2_1"

    override fun solve(inputLines: List<String>): String {
        return inputLines.fold(0) { acc, line ->
            val splitLine = line.split(":")
            val sets = splitLine[1].trim().split(";")
            var maxRed = 0
            var maxGreen = 0
            var maxBlue = 0
            sets.forEach { set ->
                set.trim().split(",").forEach {
                    val splitNumber = it.trim().split(" ")
                    val number = splitNumber.first().toInt()
                    val type = splitNumber.last()
                    when(type) {
                        "blue" -> maxBlue = max(maxBlue, number)
                        "green" -> maxGreen = max(maxGreen, number)
                        "red" -> maxRed = max(maxRed, number)
                        else -> throw IllegalArgumentException("Unsupported type: $type")
                    }
                }
            }

            acc + (maxBlue * maxRed * maxGreen)
        }.toString()
    }
}