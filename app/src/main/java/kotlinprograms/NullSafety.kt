package kotlinprograms

fun main() {
    var string1: String? = null
    val string2: String? = "Kotlin"

    if (string2 != null && string2.isNotEmpty()) {
        println("String of length ${string2.length}")
    } else {
        println("Empty string")
    }

    //Safe Calls
    println(string1?.length)
    string1 = "Something"
    println(string1?.length)

    //Elvis operator
    string1 = null
    println( string1?.length ?: "Elvis Operator Used It is Null")

    //!! Operator
    //b = null //Throws NullPointerException
    string1 = string2!!.toString()
    println(string1?.length);
}