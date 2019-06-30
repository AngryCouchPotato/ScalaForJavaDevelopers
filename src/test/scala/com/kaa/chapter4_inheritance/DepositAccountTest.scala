package com.kaa.chapter4_inheritance

import org.scalatest.FunSuite

class DepositAccountTest extends FunSuite {

  test("Invoking Withdraw method with amount == balance should work correctly") {
    // Given
    val account = new DepositAccount(200, "USD")

    // When
    account.withdraw(200)

    // Then
    assertResult(0)(account.balance)
  }

  test("Invoking Withdraw method with amount > balance should produce IllegalArgumentException") {
    assertThrows[IllegalArgumentException]{
      // Given
      val account = new DepositAccount(200, "USD")

      // When
      account.withdraw(201)
    }
  }

}
