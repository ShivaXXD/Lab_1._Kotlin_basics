fun Column(content: () -> String): String = "C[${content()}]"
fun Row(content: () -> String): String = "R[${content()}]"

fun drawNested(): String {
    // TODO: Побудуйте дерево Column { Row { "Text" } }
    return Column {
        Row {
            "Text"
        }
    }
}