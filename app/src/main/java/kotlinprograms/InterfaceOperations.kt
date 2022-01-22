package kotlinprograms

interface A {
    fun foo() { println("foo inside A interface") }
    fun bar()
}

interface B {
    fun foo() { println("foo inside B Interface") }
    fun bar() { println("bar inside B Interface") }
}

class C: A {
    override fun bar() { println("bar inside C class") }
}

class D: A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        println("bar First inside D class")
        super<B>.bar()
    }
}

fun main() {
    val objD = D()
    objD.foo()
    objD.bar()
    val objC = C()
    objC.foo()
    objC.bar()
}