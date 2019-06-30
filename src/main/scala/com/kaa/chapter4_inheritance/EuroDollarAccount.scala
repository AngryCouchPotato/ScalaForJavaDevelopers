package com.kaa.chapter4_inheritance

class EuroDollarAccount(var eurBalance: Double, val eurCurrency: String, var usdBalance: Double, val usdCurrency: String)
  extends Account(usdBalance, usdCurrency) {

  override def deposit(amount: Double): Double = {
    this.deposit(amount, "USD")
  }

  override def deposit(cashflow: Cashflow): Double ={

    this.deposit(cashflow.amount, cashflow.currency)
  }

  def deposit(amount: Double, currency: String): Double ={
    checkCurrency(currency)
    if(usdCurrency.equals(currency)){
      usdBalance += amount
      return usdBalance
    }else if(eurCurrency.equals(currency)){
      eurBalance += amount
      return eurBalance
    }else{
      throw new IllegalArgumentException(s"EuroDollarAccount cannot work with $currency currency")
    }
  }

  private def checkCurrency(cur: String): Unit ={
    if(cur == null) throw new IllegalArgumentException(s"Currency cannot be null")
  }

  override def withdraw(amount: Double): Double ={
    this.withdraw(amount, "USD")
  }

  override def withdraw(cashflow: Cashflow): Double ={
    this.withdraw(cashflow.amount, cashflow.currency)
  }

  def withdraw(amount: Double, currency: String): Double ={
    checkCurrency(currency)
    if(usdCurrency.equals(currency)){
      usdBalance -= amount
      return usdBalance
    }else if(eurCurrency.equals(currency)){
      eurBalance -= amount
      return eurBalance
    }else{
      throw new IllegalArgumentException(s"EuroDollarAccount cannot work with $currency currency")
    }
  }
}
