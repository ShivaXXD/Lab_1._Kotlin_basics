fun processInput(input: Any): Int {
    // TODO: Використайте when із перевірками 'is String' та 'is Int'
    return when (input) {
        is String -> input.length
        is Int -> input * 2
        else -> 0
    }
}