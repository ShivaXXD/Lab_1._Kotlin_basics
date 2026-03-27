class RowScope {
    fun align(): String = "Aligned!"
}
fun Row(content: RowScope.() -> String): String {
    val scope = RowScope()
    return "Row { ${scope.content()} }"
}

fun renderScoped(): String {
    // TODO: Викличте Row { ... } і всередині просто поверніть виклик align()
    return Row {
        align()
    }
}