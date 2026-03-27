fun ListItem(builder: (Int) -> String): String = builder(42)

fun drawList(): String {
    // TODO: Викличте ListItem та використайте змінну it у рядку
    return ListItem {
        "Item $it"
    }
}