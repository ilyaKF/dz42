package ru.netology

const val VK_PAY = "Vk Pay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"
const val MAX_LIMIT_IN_DAY = 150_000_00
const val MAX_LIMIT_IN_MONTH = 600_000_00
const val MAX_LIMIT_TRANSACTION_VK_PAY = 15_000_00
const val MAX_LIMIT_IN_MONTH_VK_PAY = 40_000_00

fun main() {
    println("Комиссия ${discount(MAESTRO, 10_000_00, 7_000_00)} рублей")
}

fun discount(
    typeCard: String = VK_PAY,
    sumInMonth: Int = 0,
    amountTransaction: Int
): Int {
    var result = 0
    if (typeCard != VK_PAY && (amountTransaction > MAX_LIMIT_IN_DAY || (amountTransaction + sumInMonth) > MAX_LIMIT_IN_MONTH )) {
        println("Привышен лимит перевода!")
        result = 0
    } else if (typeCard == VK_PAY && (amountTransaction > MAX_LIMIT_TRANSACTION_VK_PAY || (amountTransaction + sumInMonth) > MAX_LIMIT_IN_MONTH_VK_PAY )){
        println("Привышен лимит перевода VK Pay!")
        result = 0
    } else {
        when (typeCard) {
            MASTERCARD, MAESTRO -> result =
                if (300_00 < sumInMonth && sumInMonth < 75_000_00) 0 else (amountTransaction * 0.006 + 20_00).toInt()
            VISA, MIR -> result =
                if (amountTransaction * 0.0075 > 35_00) (amountTransaction * 0.0075).toInt() else 35_00
            VK_PAY -> result = 0
            else -> result = 0
        }
    }
    return result
}