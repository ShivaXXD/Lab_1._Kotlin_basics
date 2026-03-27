class ColumnScope(val name: String = "ColScope")
fun Column(content: ColumnScope.() -> String): String = ColumnScope().content()

fun getName(): String {
    // TODO: Викличте Column і поверніть this.name
    return Column {
        this.name
    }
}