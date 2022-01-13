package kotlinprograms

abstract class Calculator {
    abstract fun cal(number1: Int, number2: Int): Int
}

class Addition: Calculator() {
    override fun cal(number1: Int, number2: Int): Int {
        return number1 + number2
    }
}

class Subtraction: Calculator() {
    override fun cal(number1: Int, number2: Int): Int {
        return number1 - number2
    }
}

class Multiplication: Calculator() {
    override fun cal(number1: Int, number2: Int): Int {
        return number1 * number2
    }
}

fun main() {
    val addition: Calculator = Addition()
    println("Addition of two numbers ${addition.cal(4, 6)}")

    val subtraction: Calculator = Subtraction()
    println("Subtraction of two numbers ${subtraction.cal(10, 6)}")

    val multiplication: Calculator = Multiplication()
    println("Multiplication of two numbers ${multiplication.cal(20, 6)}")
}