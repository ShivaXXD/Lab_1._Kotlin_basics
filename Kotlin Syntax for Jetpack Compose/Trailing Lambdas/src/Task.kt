fun Row(modifier: String, content: () -> String): String = "Row($modifier) { ${content()} }"

fun buildUI(): String {
    // TODO: Зробіть виклик Row("Fill") { "Child" }
    return Row("Fill") {
        "Child"
    }
}