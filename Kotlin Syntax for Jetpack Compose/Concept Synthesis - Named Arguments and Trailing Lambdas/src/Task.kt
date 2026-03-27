fun Card(elevation: Int = 0, content: () -> String): String {
    return "Card(elev=$elevation) { ${content()} }"
}

fun drawCard(): String {
    // TODO: Зробіть виклик Card(elevation = 4) { "CardText" }
    return Card(elevation = 4) {
        "CardText"
    }
}