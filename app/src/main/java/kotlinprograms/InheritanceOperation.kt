package kotlinprograms

open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {

        fun fill() { println("Filling") }

        fun drawAndFill() {
            super@FilledRectangle.draw()
            fill()
            // Uses Rectangle's implementation of borderColor's get()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}")
        }
    }
}

fun main() {
    val filledRectangle = FilledRectangle()
    filledRectangle.draw()
}