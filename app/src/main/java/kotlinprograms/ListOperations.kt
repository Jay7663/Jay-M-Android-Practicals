package kotlinprograms

fun main() {
    val names = mutableListOf("Jay", "Yagnik", "Ajay", "Meet", "Satish", "Keyur", "Yagnik")
    val numbers = mutableListOf(1, 2, 3, 4, 8, 9, 10)

    //Get by Index
    println("Get by Index")
    println(names)
    println(names.get(0))
    println(names[0])
    println(names.getOrNull(5))
    println(names.getOrElse(6, { it }))
    println()

    //Elements in Range. ( 1, 2 and 3 Indexes)
    println("Elements in Range")
    println(names)
    println(names.subList(1,4))
    println()

    //Find position of Element ( Index ) Linear search
    println("Find position of Element")
    println(names)
    println(names.indexOf("Meet"))
    println(names.lastIndexOf("Yagnik"))
    println(numbers.indexOfFirst { it > 10})
    println(numbers.indexOfLast { it % 2 == 1})
    println()

    //Binary search in sorted lists. List must be Sorted
    println("Binary search in sorted lists")
    names.sort()
    println(names)
    println(names.binarySearch("Jay"))
    println(names.binarySearch("z"))
    println(names.binarySearch("Meet", 0, 4))
    println()

    //Write operations on List
    println("Write operation on List")
    //add & addAll
    println("add & addAll")
    println("Before : $numbers")
    numbers.add(4,5)
    numbers.addAll(5, listOf(6,7))
    println("After$numbers")
    println()
    //Update
    println("Update on index 9")
    println("Before : $numbers")
    numbers[9] = 0
    println("After$numbers")
    println()
    //Remove
    println("Remove")
    println("Before : $numbers")
    numbers.removeAt(1)
    println("After$numbers")
    println()
    //Sort
    println("Sort")
    names.sortDescending()
    println("Sort Descending : $names")
    names.sortBy { it.length }
    println("Sort by Length : $names")
    names.sortByDescending { it.last() }
    println("Sort Descending by Last Character : $names")
    names.shuffle()
    println("Shuffled : $names")
    names.reverse()
    println("Reverse : $names")
}
