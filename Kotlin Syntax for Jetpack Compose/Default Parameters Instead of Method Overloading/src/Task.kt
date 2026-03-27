fun Icon(iconId: Int, tint: String = "Black", size: Int = 24, contentDescription: String? = null): String {
    return "Icon $iconId ($contentDescription)"
}
fun drawIcon(): String {
    // TODO: Викличте Icon, передавши лише iconId та contentDescription
    return Icon(iconId = 101, contentDescription = "Search")
}