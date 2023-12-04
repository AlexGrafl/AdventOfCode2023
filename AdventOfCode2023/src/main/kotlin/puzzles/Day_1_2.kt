package dev.alexgrafl.puzzles

import dev.alexgrafl.StarPuzzle
import java.lang.Integer.max
import java.lang.Integer.min

private val digitMap = mapOf(
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9',
)
/**
 * Day 1, Part 2: https://adventofcode.com/2023/day/1
 * Result: 54980
 */
class Day_1_2 : StarPuzzle() {
    override val displayName = "Day 1, Part 2"
    override val inputFile = "day_1_1"
    override fun solve(inputLines: List<String>): String {
        return inputLines.foldIndexed(0) { index, acc, line ->
            val firstDigitIndexPair = line.indexOfFirst { it.isDigit() }.takeIf { it != -1 }?.let { it to line[it] }
            val firstWrittenDigitIndexPair = line.findIndexOfFirstWrittenDigit()

            val lastDigitIndexPair = line.indexOfLast { it.isDigit() }.takeIf { it != -1 }?.let { it to line[it] }
            val lastWrittenDigitIndexPair = line.findIndexOfLastWrittenDigit()

            val firstDigit = when {
                firstDigitIndexPair == null && firstWrittenDigitIndexPair == null -> null
                firstDigitIndexPair == null && firstWrittenDigitIndexPair != null -> firstWrittenDigitIndexPair
                firstDigitIndexPair != null && firstWrittenDigitIndexPair == null -> firstDigitIndexPair
                firstDigitIndexPair != null && firstWrittenDigitIndexPair != null -> if(firstDigitIndexPair.first <= firstWrittenDigitIndexPair.first) firstDigitIndexPair else firstWrittenDigitIndexPair
                else -> null
            }
            val lastDigit = when {
                lastDigitIndexPair == null && lastWrittenDigitIndexPair == null -> null
                lastDigitIndexPair == null && lastWrittenDigitIndexPair != null -> lastWrittenDigitIndexPair
                lastDigitIndexPair != null && lastWrittenDigitIndexPair == null -> lastDigitIndexPair
                lastDigitIndexPair != null && lastWrittenDigitIndexPair != null -> if(lastDigitIndexPair.first >= lastWrittenDigitIndexPair.first) lastDigitIndexPair else lastWrittenDigitIndexPair
                else -> null
            }
            var joinedNumber = ""
            if(firstDigit != null)
                joinedNumber += firstDigit.second
            if(lastDigit != null)
                joinedNumber += lastDigit.second
            val number = if(joinedNumber.isNotEmpty()) joinedNumber.toInt() else 0
            acc + number
        }.toString()
    }

    private fun String.findIndexOfFirstWrittenDigit() = digitMap.keys.asSequence()
            .map { indexOf(it) to digitMap[it] }
            .filter { it.first != -1 }
            .sortedBy { it.first }
            .firstOrNull()


    private fun String.findIndexOfLastWrittenDigit() =
        digitMap.keys.asSequence()
            .map { lastIndexOf(it) to digitMap[it] }
            .filter { it.first != -1 }
            .sortedByDescending { it.first }
            .firstOrNull()
}