// TODO: Додайте значення за замовчуванням "Guest" для параметра name
fun greetUser(name: String = "Guest"): String {
    return "Welcome, $name!"
}

fun callGreet(): String {
    return greetUser() // Цей виклик має запрацювати після вашої зміни
}