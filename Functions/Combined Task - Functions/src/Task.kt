// TODO: 1. Оголосіть single-expression функцію formatUser з параметрами за замовчуванням
fun formatUser(login: String, domain: String = "example.com", isActive: Boolean = true) =
    "[$login@$domain] - Active: $isActive"

fun testUser(): String {
    // TODO: 2. Поверніть результат виклику formatUser("admin", isActive = false)
    return formatUser(login = "admin", isActive = false)
}