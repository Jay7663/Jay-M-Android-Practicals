package kotlinprograms

import android.os.Build

fun main() {

    val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)

    //Get value by key
    println(numbersMap)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        println(numbersMap.getOrDefault("four", 10))
    }
    println(numbersMap["five"])

    println("All Keys : ${numbersMap.keys}")
    println("All Values  ${numbersMap.values}")
    println()

    //Filter
    println("Filter")
    val filteredMap = numbersMap.filter{(key, value) -> key.endsWith("o") && value > 1}
    println("Filterd values : $filteredMap")
    println("Filterd values : ${numbersMap.filterKeys { it.endsWith('o') }}")
    println()

    //Plus "+" and Minus "-" Operation
    println(numbersMap + Pair("four", 4))
    println(numbersMap + mapOf("five" to 5, "one" to 11))
    println(numbersMap)
    println()

    println(numbersMap - "one")
    println(numbersMap - listOf("two", "four"))
    println(numbersMap)
    println()

    //Add and update entries
    numbersMap.put("four", 4)
    println("Added last : $numbersMap")

    numbersMap.putAll(setOf("five" to 5 , "six" to 6))
    println("Added last 2 : $numbersMap")

    numbersMap["six"] = 9
    println("Updated index six : $numbersMap")

    numbersMap.remove("six")
    println("Removed index six : $numbersMap")

    numbersMap.values.remove(5)
    println("Removed value 5 : $numbersMap")
}