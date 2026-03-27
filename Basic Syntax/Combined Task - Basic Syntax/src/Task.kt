fun calculateDiscount(): String {
    // TODO: Оголосіть item, price. Зменште price та поверніть відформатований рядок.
    val item = "Laptop"
    var price = 1000
    price -= 150
    return "Price of $item is $price"
}