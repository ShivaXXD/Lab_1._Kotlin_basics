fun getGrade(score: Int): String {
    // TODO: Використайте when (score) { in 90..100 -> "A" ... }
    return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
}