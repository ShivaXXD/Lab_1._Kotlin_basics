// TODO: Змініть тип повернення на List<String>
fun getReadOnlyList(): List<String> {
    val list = mutableListOf("A", "B", "C")
    list.add("D")
    return list
}