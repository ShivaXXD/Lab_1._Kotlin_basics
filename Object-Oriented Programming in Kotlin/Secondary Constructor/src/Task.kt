class Rectangle(val width: Int, val height: Int) {
    // TODO: Створіть вторинний конструктор constructor(size: Int) : this(...)
    constructor(size: Int) : this(size, size)
}

fun createSquare(): Int {
    val square = Rectangle(5)
    return square.width * square.height
}