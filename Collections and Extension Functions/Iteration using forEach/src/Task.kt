fun processNames(names: List<String>): String {
    var result = ""
    // TODO: Використайте names.forEach { result += "$it, " }
    names.forEach {
        result += "$it, "
    }
    return result
}