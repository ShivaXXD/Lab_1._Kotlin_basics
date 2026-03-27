class Modifier(val id: String)
fun Box(modifier: Modifier): String = "Box with ${modifier.id}"

fun createBox(): String {
    // TODO: Створіть Modifier("ID_1") без слова new та передайте його в Box()
    val modifier = Modifier("ID_1")
    return Box(modifier)
}