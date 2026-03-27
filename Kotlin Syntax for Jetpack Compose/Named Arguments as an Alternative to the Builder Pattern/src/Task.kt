fun MyText(text: String, color: String = "Black", fontSize: Int = 14): String {
    return "Text: $text, Color: $color, Size: $fontSize"
}

fun callText(): String {
    // TODO: Викличте MyText з іменованими аргументами text і fontSize
    return MyText(text = "Compose", fontSize = 24)
}