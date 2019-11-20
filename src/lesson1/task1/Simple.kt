@file:Suppress("UNUSED_PARAMETER")
package lesson1.task1

import lesson6.task1.timeStrToSeconds
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
        (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции

fun main(args: Array<String>) {
    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    println("Root product: $x1x2")
}
 */
/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).


fun main(args: Array<String>) {
    val result = seconds(8, 20, 35)
    println("30035: $result")
}
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    val countMinutes = hours * 60 + minutes
    val countSeconds = countMinutes * 60 + seconds
    return countSeconds
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.


fun main(args: Array<String>) {
    val result1 = lengthInMeters(8, 2, 11)
    println("18.98: $result1")
}
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    val sagenetsToVershoks = sagenes * 48
    val arshinsToVershoks = arshins * 48 / 3
    val sumVershoks = sagenetsToVershoks + arshinsToVershoks + vershoks
    val vershokToMeters = 4.445 / 100
    var result = sumVershoks * vershokToMeters
    return result

}
/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).


fun main(args: Array<String>) {
    val result1 = angleInRadian(36, 14, 35)
    println("0.63256: $result1")
}
 */

fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val degToAngle = deg * PI / 180
    val minToAngle = min * PI / 180 / 60
    val secToAngle = sec * PI / 180 / 60 / 60
    val result = degToAngle + minToAngle + secToAngle
    return result
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5


fun main(args: Array<String>) {
    val result1 = trackLength(3.0, 0.0, 0.0, 4.0)
    println("5: $result1")
}
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val x1x2 = x2 - x1
    val y1y2 = y2 - y1
    val d = sqrt(x1x2 * x1x2 + y1y2 * y1y2 )
    return d
}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).

fun main(args: Array<String>) {
    val result1 = thirdDigit(3801)
    println("8 : $result1")
}
 */
fun thirdDigit(number: Int): Int {
    val x = number / (10 * 10)
    val x3 = x % 10
    return x3
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).


fun main(args: Array<String>) {
    val result1 = travelMinutes(9, 25, 13, 1)
    println("216 : $result1")
}
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    val startMin = hoursDepart * 60 + minutesDepart
    val finishMin = hoursArrive * 60 + minutesArrive
    val time = finishMin - startMin
    return time
}

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля

fun main(args: Array<String>) {
    val result1 = accountInThreeYears(100, 10)
    println("133.1 : $result1")
}
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    val accountInOneYear: Double = percent / 100.0 +1.0
    val account: Double = accountInOneYear.pow(3.0) * initial
    return account
}
/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).


fun main(args: Array<String>) {
    val result1 = numberRevert(478)
    println("874 : $result1")
}
 */
fun numberRevert(number: Int): Int {
    val firstNumber = number % 10
    val secondNumber = number / 10 % 10
    val thirdNumber =number / 100
    val revert = firstNumber * 100 + secondNumber * 10 + thirdNumber
    return revert
}