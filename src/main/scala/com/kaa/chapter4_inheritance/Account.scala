package com.kaa.chapter4_inheritance

class Account(var balance: Double, val currency: String) {

  def deposit(amount: Double): Double ={
    balance += amount
    balance
  }

  def deposit(cashflow: Cashflow): Double ={
    checkCurrency(cashflow.currency)
    balance += cashflow.amount
    balance
  }

  private def checkCurrency(cur: String): Unit ={
    if(cur == null) throw new IllegalArgumentException(s"Currency cannot be null")
    if(cur != this.currency) throw new IllegalArgumentException(s"Account has another currency: $currency")
  }

  def withdraw(amount: Double): Double ={
    balance -= amount
    balance
  }

  def withdraw(cashflow: Cashflow): Double ={
    checkCurrency(cashflow.currency)
    balance -= cashflow.amount
    balance
  }
}
