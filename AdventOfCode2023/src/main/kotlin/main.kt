package dev.alexgrafl

import dev.alexgrafl.puzzles.Day_1_1
import dev.alexgrafl.puzzles.Day_1_2
import dev.alexgrafl.puzzles.Day_2_1
import dev.alexgrafl.puzzles.Day_2_2

fun main() {
    puzzles.forEach(StarPuzzle::loadInputAndSolve)
}

val puzzles = listOf(
    Day_1_1(),
    Day_1_2(),
    Day_2_1(),
    Day_2_2(),
)