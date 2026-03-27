fun countdown(start: Int): String {
    var result = ""
    // TODO: Використайте for (i in start downTo 1) і додавайте "$i " до result
    for (i in start downTo 1) {
        result += "$i "
    }
    return result
}