fun toUpperCaseSafe(text: String?): String {
    // TODO: Перевірте if (text != null), використайте .uppercase(), інакше поверніть "EMPTY"
    if (text != null) {
        return text.uppercase()
    } else {
        return "EMPTY"
    }
}