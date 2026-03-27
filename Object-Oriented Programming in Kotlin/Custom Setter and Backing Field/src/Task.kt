class BankAccount {
    var balance: Int = 0
    // TODO: Напишіть кастомний set(value) { ... } з використанням field
    set(value) {
        if (value >= 0) {
            field = value
        }
    }
}