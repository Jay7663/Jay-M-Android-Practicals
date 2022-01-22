package kotlinprograms

fun main() {
    val names = listOf("Jay", "Yagnik", "Meet", "Satish", "Ajay")

    for (name in names) {
        println(name)
    }

    for (i in 0..10) {
        print("$i ")
    }
    println()

    for (i in 0..10 step 2) {
        print("$i ")
    }
    println()

    for (i in 10 downTo 0 step 2) {
        print("$i ")
    }
    println()

    var x = 10

    while (x > 0) {
        print("$x ")
        x--
    }
    println()

    do {
        println("Executed once")
    } while(x > 0)
    println()

    //when
    x = 3;

    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
}