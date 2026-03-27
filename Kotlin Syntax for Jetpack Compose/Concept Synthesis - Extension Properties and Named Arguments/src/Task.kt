val Int.dp: String get() = "${this}dp"

fun Padding(all: String): String = "Pad: $all"

fun setupPadding(): String {
    // TODO: Викличте Padding, вказавши all = 16.dp
    return Padding(all = 16.dp)
}