package kotlinprograms

fun main() {
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val temporary = this[index1]
        this[index1] = this[index2]
        this[index2] = temporary
    }

    val list = mutableListOf(1, 2, 3, 4)
    list.swap(0, 2)
    println("Swap 0 and 2 index : $list")

    val listString = mutableListOf("one", "two", "three" , "four")
    listString.swap(0, 2)
    println("Swap 0 and 2 index : $listString")
}