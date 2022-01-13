package kotlinprograms

data class DataClass(val name: String) {
    var age: Int = 0
}

fun main() {
    val person1 = DataClass("John")
    val person2 = DataClass("John")
    person1.age = 10
    person2.age = 20
    println("person1 == person2: ${person1 == person2}")
    println("person1 with age ${person1.age}: ${person1}")
    println("person2 with age ${person2.age}: ${person2}")
}