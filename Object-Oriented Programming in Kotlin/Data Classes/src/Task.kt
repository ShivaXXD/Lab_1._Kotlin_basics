// TODO: Додайте ключове слово data перед класом
data class User(val login: String, val id: Int)

fun compareUsers(): Boolean {
    val user1 = User("admin", 1)
    val user2 = User("admin", 1)
    return user1 == user2 // Для звичайного класу це поверне false, для data class - true
}