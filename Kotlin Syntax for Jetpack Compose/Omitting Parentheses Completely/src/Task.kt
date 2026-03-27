fun Column(content: () -> String): String = "Col:\n  ${content()}"

fun drawColumn(): String {
    // TODO: Викличте Column без ()
    return Column {
        "Item"
    }
}