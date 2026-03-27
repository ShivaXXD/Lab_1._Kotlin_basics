// TODO: Оголосіть клас Worker(val name: String, val hourlyRate: Int)
class Worker(val name: String, val hourlyRate: Int) {
// Додайте init { ... }
init {
    if (hourlyRate <= 0) {
        throw IllegalArgumentException("Ставка hourlyRate має бути більше 0")
    }
}
// Додайте var hoursWorked та val salary
var hoursWorked: Int = 0
    set(value) {
        if (value >= 0) {
            field = value
        }
    }

    val salary: Int
        get() = hourlyRate * hoursWorked
}