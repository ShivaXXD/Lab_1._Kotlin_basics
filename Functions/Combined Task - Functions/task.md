Об'єднаємо single-expression функції, параметри за замовчуванням та іменовані аргументи!
1. Створіть single-expression функцію `formatUser`, яка приймає:
  - `login: String`
  - `domain: String` (за замовчуванням `"example.com"`)
  - `isActive: Boolean` (за замовчуванням `true`)
    Вона має повертати рядок: `"[login@domain] - Active: isActive"`.
2. У функції `testUser` викличте `formatUser`, передавши `login = "admin"` та вказавши `isActive = false` через іменований аргумент (пропустивши `domain`).