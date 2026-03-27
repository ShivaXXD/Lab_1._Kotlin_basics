fun generateGreeting(name: String?): String {
    // TODO: Обробіть null та порожній рядок. Значення за замовчуванням - "Guest".
    // Поверніть рядок формату "Welcome, Name!"
    val finalName = name?.takeIf { it.isNotEmpty() } ?: "Guest"
    return "Welcome, $finalName!"
}