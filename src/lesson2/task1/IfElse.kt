@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.accountInThreeYears
import lesson1.task1.discriminant
import kotlin.math.*
import kotlin.system.measureTimeMillis

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when (age){
    21 -> "$age год"
    32 -> "$age года"
    12 -> "$age лет"
    else -> "другой возраст $age"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */

fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val l1 = t1 * v1
    val l2 = t2 * v2
    val l3 = t3 * v3
    val l = l1 + l2 + l3
    val lengthForHalfWay = l / 2
    val x1 = lengthForHalfWay / v1
    if (lengthForHalfWay < l1) return x1 // первая половина пути меньше первого отрезка пути
    if (lengthForHalfWay == l1) return t1 // первая половина пути равняется первому отрезку пути
    val x2 = t1 + (lengthForHalfWay - l1) / v2
    val l1l2 = l1 + l2
    if (lengthForHalfWay in l1..l1l2) return x2 // первая половина пути больше первого отрезка пути и меньше первых друх
    val t1t2 = t1 + t2
    if (lengthForHalfWay == l1l2) return t1t2 // первая половина пути равняется первым друм отрезкам
    val x3 = t1t2 + (lengthForHalfWay - l1l2) / v3
    return x3
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    if (kingX == rookX1 && kingX == rookX2) return 3
    if (kingX == rookX1 && kingY == rookY2) return 3
    if (kingY == rookY1 && kingY == rookY2) return 3
    if (kingY == rookY1 && kingX == rookX2) return 3
    if (kingX == rookX2 || kingY == rookY2) return 2 // угроза от 2
    if (kingX == rookX1 || kingY == rookY1) return 1 // угроза от 1
    return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    if (kingX == rookX || kingY == rookY && abs(bishopX - kingX) != abs(bishopY - kingY)) return 1
    if (kingX != rookX && kingY != rookY && abs(bishopX - kingX) == abs(bishopY - kingY)) return 2
    if (kingX == rookX || kingY == rookY && abs(bishopX - kingX) == abs(bishopY - kingY)) return 3
    return 0
    }

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */

fun triangleKind(a: Double, b: Double, c: Double): Double {
    if (a > (b + c) || b > (a + c) || c > (a + b)) return -1.0
    val A = a * a
    val B = b * b
    val C = c * c
    if (A + B == C || B + C == A || C + A == B) return 1.0
    if (A + B < C || B + C < A || C + A < B) return 2.0
    return 0.0
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (b == c && d > b) return 0 // a b (c) d
    if (d == a && b > c) return 0 // c d (a) b
    if (a < c && d < b) return (d - c) // a c d b
    if (c < a && b < d) return (b - a) // c a b d
    if (c in a..b && d > b) return (b - c) // a c b d
    if (a in c .. d && b > d) return (d - a) // c a d b
    return (-1)
}
