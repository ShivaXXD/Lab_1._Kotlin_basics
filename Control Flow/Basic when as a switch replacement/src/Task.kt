fun getNumberName(n: Int): String {
    // TODO: Використайте when для перевірки значення n
    return when (n) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        else -> "Unknown"
    }
}