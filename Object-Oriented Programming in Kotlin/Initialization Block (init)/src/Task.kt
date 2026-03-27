class Product(val price: Double) {
    // TODO: Додайте блок init { ... }, який викидає IllegalArgumentException, якщо price < 0
    init {
        if (price < 0) {
            throw IllegalArgumentException("Price cannot be negative")
        }
    }
}