fun formatDate(day: Int, month: String, year: Int): String {
    return "$day $month $year"
}

fun callFormatDate(): String {
    // TODO: Викличте formatDate, використовуючи іменовані аргументи в зміненому порядку (year, month, day)
    return formatDate(year = 2025, month = "October", day = 10)
}