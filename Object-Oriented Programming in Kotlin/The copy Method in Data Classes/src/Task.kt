data class Book(val title: String, val author: String, val price: Int)

fun applyDiscount(book: Book): Book {
    // TODO: Поверніть book.copy(price = ...)
    return book.copy(price = 150)
}