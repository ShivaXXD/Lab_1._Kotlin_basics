fun trafficLightAction(color: String): String {
    // TODO: Поверніть результат виразу when (color) { ... }
    return when (color) {
        "Red" -> "Stop"
        "Yellow" -> "Wait"
        "Green" -> "Go"
        else -> "Error"
    }
}