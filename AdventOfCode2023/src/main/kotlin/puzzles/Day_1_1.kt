package dev.alexgrafl.puzzles

import dev.alexgrafl.StarPuzzle

/**
 * Day 1, Part 1: https://adventofcode.com/2023/day/1
 * Result: 55816
 */
class Day_1_1 : StarPuzzle() {
    override val displayName = "Day 1, Part 1"
    override val inputFile = "day_1_1"
    override fun solve(inputLines: List<String>): String {
        return inputLines.fold(0) { acc, line ->
            val firstDigit = line.firstOrNull { it.isDigit() } ?: 0
            val lastDigit = line.lastOrNull { it.isDigit() } ?: 0
            acc + "$firstDigit$lastDigit".toInt()
        }.toString()
    }
}