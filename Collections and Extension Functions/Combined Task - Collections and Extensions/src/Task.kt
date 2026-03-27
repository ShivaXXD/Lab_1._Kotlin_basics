// TODO: Напишіть функцію-розширення List<String>.getImportantWords(): List<String>
fun List<String>.getImportantWords(): List<String> {
    return this.filter { it.startsWith("K") }
        .map { it.uppercase() }
}