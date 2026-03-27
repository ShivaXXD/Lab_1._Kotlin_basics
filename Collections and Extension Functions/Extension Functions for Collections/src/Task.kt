// TODO: Оголосіть fun List<Int>.sumOdd(): Int
fun List<Int>.sumOdd(): Int {
    var sum = 0
    for (item in this) {
        if (item % 2 != 0) {
            sum += item
        }
    }
    return sum
}