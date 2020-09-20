@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var number: Int = n
    var count: Int = 0
    do {
        number /= 10
        count++
    } while (number > 0)
    return count
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    val number: Int = n
    if (number <= 2) return 1
    var resultA: Int = 1
    var resultB: Int = 1
    var resultC: Int
    for (i in 3..number) {
        resultC = resultA
        resultA += resultB
        resultB = resultC
    }
    return resultA
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int
{
    val number: Int = n
    if (number <= 1) return  1
    var mid: Int = 1
    for (i in 2..number)
    {
        if (number % i == 0)
        {
            mid = i
            break
        }
    }
    return  mid
}


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int
{
    val number: Int = n
    var output: Int = 1
    for (i in number-1 downTo 1)
    {
        if (number % i == 0)
        {
            output = i
            break
        }
    }
    return  output
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int
{
    var number: Int = x
    var i: Int = 0
    while(number != 1)
    {
        if(number % 2 == 0)
        {
            number = number / 2
        }
        else
        {
            number = number * 3 + 1
        }
        ++i
    }
    return i
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int
{
    var number1: Int = m
    var number2: Int = n
    var number3: Int = m * n
    var max: Int = max(number1,number2)
    for (i in 2..max)
    {
        if(number1 % i == 0 && number2 % i == 0)
        {
            number1 /= i
            number2 /= i
            max /= i
            number3 /= i
        }
    }
    return number3
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean
{
    if(lcm(m,n) == m * n) return true
    else return false
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean
{
    val number1: Int = m
    val number2: Int = n
    for (i in 1..number2 )
    {
        if(i * i >= number1 && i * i <= number2)  return true
    }
    return false
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int
{
    var numberBefore: Int = n
    var i: Int = 0
    do {
        i *= 10
        i += numberBefore % 10
        numberBefore /= 10
    }while (numberBefore  != 0)
    return i
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean
{
    val number: Int = n
    if (revert(number) == number) return true
    else return false
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean
{
    var number: Int = n
    val i:Int = n % 10
    while (number / 10 != 0)
    {
        number /= 10
        if (number % 10 != i) return true
    }
    return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double
{
    var i: Int = 1
    val number: Double = x
    val exact: Double = eps
    while(number.pow(i) / factorial(i) >= abs(exact))
    {
        i = i + 2
    }
    var out:Double = 0.0
    var fuhao: Int = 1
    for(k in  1..i step 2)
    {
        out = number.pow(k) / factorial(k) * (-1.0).pow(fuhao + 1) + out
        ++fuhao
    }
    return out
}


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double
{
    var i: Int = 2
    val number: Double = x
    val exact: Double = eps
    while(number.pow(i) / factorial(i) >= abs(exact))
    {
        i = i + 2
    }
    var out:Double = -1.0
    var fuhao: Int = 1
    for(k in  2..i step 2)
    {
        out = number.pow(k) / factorial(k) * (-1.0).pow(fuhao) + out
        ++fuhao
    }
    return out
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int
{
    var number: Int = n
    var i: Int = 0
    var sqr: Int = 0
    var out: Int = 0
    while (number > 0)
    {
        ++ i
        sqr = i * i
        var w: Int = 1
        while (sqr / 10 != 0)
        {
            ++w
            sqr = sqr / 10
        }
        number -= w
    }
    sqr = i * i
    val wei: Int = abs(number)+1
    for (k in 1..wei)
    {
        out = sqr % 10
        sqr /= 10
    }
    return out
}


/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int
{
    var number: Int = n
    var i: Int = 0
    var shu: Int = 0
    var out: Int = 0
    while(number > 0)
    {
        ++i
        shu = fib(i)
        var w: Int = 1
        while (shu / 10 != 0)
        {
            ++w
            shu /= 10
        }
        number -= w
    }
    shu = fib(i)
    val wei: Int = abs(number) + 1
    for (k in 1..wei)
    {
        out = shu % 10
        shu /= 10
    }
    return out
}
