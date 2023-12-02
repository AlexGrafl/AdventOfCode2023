package dev.alexgrafl

import java.io.File
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
abstract class StarPuzzle {
    protected abstract val displayName: String
    protected abstract val inputFile: String
    protected abstract fun solve(inputLines: List<String>): String

    fun loadInputAndSolve(): String {
        println("Starting to solve $displayName...")
        val input = File("input/$inputFile").readLines()
        val timedValue = measureTimedValue {
            solve(input)
        }
        println("Finished. Result: ${timedValue.value}")
        println("Time taken: ${timedValue.duration}")
        return timedValue.value
    }
}