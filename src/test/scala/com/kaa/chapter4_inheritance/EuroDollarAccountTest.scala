package com.kaa.chapter4_inheritance

import org.scalatest.FunSuite

class EuroDollarAccountTest extends FunSuite {

  test("Deposit method work correctly for EuroDollarAccount") {
    // Given
    val account = new EuroDollarAccount(500, "EURO", 700, "USD")

    // When
    account.deposit(200, "EURO")
    account.deposit(150, "USD")

    // Then
    assertResult(700)(account.eurBalance)
    assertResult(850)(account.usdBalance)
  }

  test("Withdraw method work correctly for EuroDollarAccount") {
    // Given
    val account = new EuroDollarAccount(500, "EURO", 700, "USD")

    // When
    account.withdraw(100, "EURO")
    account.withdraw(50, "USD")

    // Then
    assertResult(400)(account.eurBalance)
    assertResult(650)(account.usdBalance)
  }

  test("Invoking deposit method with incorrect currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException] {
      // Given
      val account = new EuroDollarAccount(500, "EURO", 700, "USD")

      // When
      account.deposit(100, "CZK")
    }
  }

  test("Invoking withdraw method with incorrect currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException] {
      // Given
      val account = new EuroDollarAccount(500, "EURO", 700, "USD")

      // When
      account.withdraw(100, "CZK")
    }
  }

  test("Invoking deposit method with nullable currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException] {
      // Given
      val account = new EuroDollarAccount(500, "EURO", 700, "USD")

      // When
      account.deposit(100, null)
    }
  }

  test("Invoking withdraw method with nullable currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException] {
      // Given
      val account = new EuroDollarAccount(500, "EURO", 700, "USD")

      // When
      account.withdraw(100, null)
    }
  }
}
