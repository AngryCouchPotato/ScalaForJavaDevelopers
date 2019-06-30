package com.kaa.chapter4_inheritance

import org.scalatest.FunSuite

class AccountTest extends FunSuite {

  test("Deposit method works correctly for Account") {
    // Given
    val account = new Account(100, "USD")

    // When
    account.deposit(100)

    // Then
    assertResult(200)(account.balance)
  }

  test("Withdraw method works correctly for Account") {
    // Given
    val account = new Account(100, "USD")

    // When
    account.withdraw(10)

    // Then
    assertResult(90)(account.balance)
  }

  test("Deposit method works correctly with CashFlow for Account") {
    // Given
    val account = new Account(100, "USD")

    // When
    account.deposit(new Cashflow(150, "USD", null))

    // Then
    assertResult(250)(account.balance)
    assertResult("USD")(account.currency)
  }

  test("Withdraw method works correctly with CashFlow for Account") {
    // Given
    val account = new Account(200, "USD")

    // When
    account.withdraw(new Cashflow(50, "USD", null))

    // Then
    assertResult(150)(account.balance)
    assertResult("USD")(account.currency)
  }

  test("Invoking Deposit method with CashFlow with nullable currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException]{
      // Given
      val account = new Account(200, "USD")

      // When
      account.deposit(new Cashflow(150, null, null))
    }
  }

  test("Invoking Withdraw method with CashFlow with nullable currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException]{
      // Given
      val account = new Account(200, "USD")

      // When
      account.withdraw(new Cashflow(150, null, null))
    }
  }

  test("Invoking Deposit method with CashFlow with wrong currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException]{
      // Given
      val account = new Account(200, "USD")

      // When
      account.deposit(new Cashflow(150, "EURO", null))
    }
  }

  test("Invoking Withdraw method with CashFlow with wrong currency should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException]{
      // Given
      val account = new Account(200, "USD")

      // When
      account.withdraw(new Cashflow(150, "EURO", null))
    }
  }


}
