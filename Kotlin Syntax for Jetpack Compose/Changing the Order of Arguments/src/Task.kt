fun MyButton(onClick: String, enabled: Boolean): String = "Button($onClick, $enabled)"

fun renderButton(): String {
    // TODO: Викличте MyButton, змінивши порядок аргументів
    return MyButton(enabled = false, onClick = "Action")
}