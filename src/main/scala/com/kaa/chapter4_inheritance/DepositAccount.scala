package com.kaa.chapter4_inheritance

class DepositAccount(balance: Double, currency: String) extends Account(balance, currency) {

  override def withdraw(amount: Double): Double ={
    if(balance < amount) throw new IllegalArgumentException(s"Account's balance($balance) could not be less than amount of transaction($amount).")
    super.withdraw(amount)
  }
}
