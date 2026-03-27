fun processData(numbers: List<Int>): List<Int> {
    // TODO: Відфільтруйте it > 0, а потім зробіть map { it * 2 }
    return numbers.filter { it > 0 }.map { it * 2 }
}