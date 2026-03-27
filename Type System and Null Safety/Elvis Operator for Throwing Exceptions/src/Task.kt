fun requireValidString(text: String?): String {
    // TODO: Поверніть text або викиньте IllegalArgumentException, використовуючи ?:
    return text ?: throw IllegalArgumentException()
}