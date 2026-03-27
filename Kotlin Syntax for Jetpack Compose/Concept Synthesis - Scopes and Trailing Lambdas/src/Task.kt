class LazyItemScope {
    fun item(block: () -> String): String = "Item(${block()})"
}
fun LazyColumn(content: LazyItemScope.() -> String): String {
    return "Lazy[${LazyItemScope().content()}]"
}

fun renderList(): String {
    // TODO: LazyColumn { item { "Data" } }
    return LazyColumn {
        item {
            "Data"
        }
    }
}