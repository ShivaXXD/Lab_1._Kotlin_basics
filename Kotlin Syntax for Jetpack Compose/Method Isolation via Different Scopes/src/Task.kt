class RowScope { fun weight() = "W" }
class ColumnScope { fun gravity() = "G" }

fun Row(content: RowScope.() -> String) = RowScope().content()
fun Column(content: ColumnScope.() -> String) = ColumnScope().content()

fun testScopes(): String {
    // TODO: Поверніть Row { weight() } + Column { gravity() }
    return Row { weight() } + Column { gravity() }
}