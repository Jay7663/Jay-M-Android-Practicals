package kotlinprograms

fun main() {
    val numbers = setOf("one", "two", "three")

    println(numbers union setOf("four", "five"))
    println(setOf("four", "five") union numbers)
    println(numbers intersect setOf("two", "one"))
    println(numbers subtract setOf("three", "four"))
    println(numbers subtract setOf("four", "three"))
    println()

    //Union intersect and subtract on List
    val list1 = listOf(1, 1, 2 ,3, 5, 8, -1)
    val list2 = listOf(1, 1, 2, 2 ,3, 5)
    println(list1 intersect list2)
    println(list1 union list2)
}