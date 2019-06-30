package com.kaa.chapter3_basicsyntax

import java.sql
import java.time.LocalDateTime
import java.util.{Calendar, Date}

import org.scalatest.FunSuite

class UtilsTest extends FunSuite {

  test("Factorial=1 when num = 1") {
    assertResult(1)(Utils.factorial(1));
  }

  test("Factorial=2 when num = 2") {
    assertResult(2)(Utils.factorial(2));
  }

  test("Factorial=6 when num = 3") {
    assertResult(6)(Utils.factorial(3));
  }

  test("Factorial=40320 when num = 8") {
    assertResult(40320)(Utils.factorial(8));
  }

  test("Factorial=87178291200 when num = 14") {
    assertResult(87178291200L)(Utils.factorial(14));
  }

  test("isLeapYear=true when num = 2000-06-15") {
    assertResult(true)(Utils.isLeapYear("2000-06-15"));
  }

  test("isLeapYear=false when num = 1990-06-15") {
    assertResult(false)(Utils.isLeapYear("1990-06-15"));
  }

  test("isLeapYear=true when num = 2016-01-12") {
    var calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2016)
    calendar.set(Calendar.MONTH, 1)
    calendar.set(Calendar.DAY_OF_MONTH, 12)
    assertResult(true)(Utils.isLeapYear(calendar.getTime));
  }

  test("isLeapYear=false when num = 2018-02-03") {
    var calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2018)
    calendar.set(Calendar.MONTH, 2)
    calendar.set(Calendar.DAY_OF_MONTH, 3)
    assertResult(false)(Utils.isLeapYear(calendar.getTime));
  }

  test("isLeapYear=true when num = 2020-05-05") {
    var calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2020)
    calendar.set(Calendar.MONTH, 5)
    calendar.set(Calendar.DAY_OF_MONTH, 5)
    assertResult(true)(Utils.isLeapYear(new sql.Date(calendar.getTimeInMillis)));
  }

  test("isLeapYear=false when num = 2019-06-06") {
    var calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2019)
    calendar.set(Calendar.MONTH, 6)
    calendar.set(Calendar.DAY_OF_MONTH, 6)
    assertResult(false)(Utils.isLeapYear(calendar.getTime));
  }
}
