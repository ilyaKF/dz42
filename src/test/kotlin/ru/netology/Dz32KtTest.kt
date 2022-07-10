package ru.netology

import org.junit.Test

import org.junit.Assert.*

class Dz32KtTest {

    @Test
    fun discount_over_amountTransaction() {
        //arrange
        val typeCardTest = MASTERCARD
        val sumInManthTest = 0
        val amountTransactionTest = 150_001_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(0, result)

    }

    @Test
    fun discount_over_sumInMonth() {
        //arrange
        val typeCardTest = MAESTRO
        val sumInManthTest = 600_000_00
        val amountTransactionTest = 150_001_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(0, result)

    }

    @Test
    fun discount_over_MAX_LIMIT_TRANSACTION_VK_PAY() {
        //arrange
        val typeCardTest = VK_PAY
        val sumInManthTest = 0
        val amountTransactionTest = 16_000_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(0, result)

    }

    @Test
    fun discount_over_MAX_LIMIT_IN_MONTH_VK_PAY() {
        //arrange
        val typeCardTest = VK_PAY
        val sumInManthTest = 40_000_00
        val amountTransactionTest = 16_000_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(0, result)

    }

    @Test
    fun discount_MASTERCARD() {
        //arrange
        val typeCardTest = MASTERCARD
        val sumInManthTest = 1000_00
        val amountTransactionTest = 100_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals("0", result)

    }

    @Test
    fun discount_MAESTRO() {
        //arrange
        val typeCardTest = MAESTRO
        val sumInManthTest = 80_000_00
        val amountTransactionTest = 100_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(20_60, result)

    }

    @Test
    fun discount_VISA() {
        //arrange
        val typeCardTest = VISA
        val sumInManthTest = 1000_00
        val amountTransactionTest = 100_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(35_00, result)

    }

    @Test
    fun discount_MIR() {
        //arrange
        val typeCardTest = MIR
        val sumInManthTest = 0
        val amountTransactionTest = 10_000_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(75_00, result)

    }

    @Test
    fun discount_default() {
        //arrange

        //act
        val result = discount()

        //assert
        assertEquals(0, result)

    }

    @Test
    fun discount_unknown_card() {
        //arrange
        val typeCardTest = "Card"
        val sumInManthTest = 0
        val amountTransactionTest = 10_000_00

        //act
        val result = discount(
            typeCard = typeCardTest,
            sumInMonth = sumInManthTest,
            amountTransaction = amountTransactionTest
        )

        //assert
        assertEquals(0, result)

    }
}