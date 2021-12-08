import java.io.File
import kotlin.math.pow

class Day3 {

    private val fileName: String = "/Users/mican/src/aoc2021_kotlin/src/main/resources/day3.txt"

    fun a() {
        val input: List<String> = File(fileName).readLines()
        val numberOfRows = input.size
        val m: MutableMap<Int, Int> = mutableMapOf()
        for (item in input) {
            for ((index, digit) in item.toList().withIndex()) {
                m.putIfAbsent(index, 0)
                m[index] = m[index]!! + digit.digitToInt()
            }
        }

        val mBool = m.values.map {v -> v>numberOfRows/2}.map { v -> if (v) "1" else "0" }
        val s : String = mBool.joinToString(",").replace(",", "")
        val gammaRate = Integer.parseInt(s, 2)

        val rowLength = mBool.size
        val totalCount = 2.0.pow(rowLength.toDouble()).toInt()
        val epsilonRate = totalCount - gammaRate - 1
        val answer = gammaRate*epsilonRate

        print("3a:TotalRows=$numberOfRows, gamma = $gammaRate, epsilomnRate = $epsilonRate, ans = $answer  \n")
    }

    fun b() {
        val input: List<String> = File(fileName).readLines()

        val columnSize = input.get(0).length
        var remaningData = input
        for (i in 0 until columnSize) {
            val zeroCount = remaningData.stream().filter {row -> row.get(i).toString() == "0" }.count()
            val oneCount = remaningData.stream().filter {row -> row.get(i).toString() == "1" }.count()
            remaningData = remaningData.filter { row -> row.get(i).toString().toInt() == if (zeroCount > oneCount) 0 else 1 }
            if (remaningData.size == 1) break
        }

        val oxygenGeneratorRating = Integer.parseInt(remaningData.toString()
            .replace("]", "").replace("[",""), 2)

        var remaningDataCo2Scrubber = input
        for (i in 0 until columnSize) {
            val zeroCount = remaningDataCo2Scrubber.stream().filter { row -> row.get(i).toString() == "0" }.count()
            val oneCount = remaningDataCo2Scrubber.stream().filter { row -> row.get(i).toString() == "1" }.count()
            remaningDataCo2Scrubber = remaningDataCo2Scrubber.filter { row -> row.get(i).toString().toInt() == if (zeroCount <= oneCount) 0 else 1}
            if (remaningDataCo2Scrubber.size == 1) break
        }

        val co2ScrupperData = Integer.parseInt(remaningDataCo2Scrubber.toString()
            .replace("]", "").replace("[",""), 2)
        print("3B answer: ${co2ScrupperData*oxygenGeneratorRating}")
    }

}