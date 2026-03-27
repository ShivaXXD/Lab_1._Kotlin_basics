fun clickable(action: (String) -> String): String = action("click")

fun addClick(): String {
    // TODO: Поверніть результат clickable, викликавши uppercase() для it
    return clickable {
        it.uppercase()
    }
}