package com.kaa.chapter3_basicsyntax

import java.sql
import java.time.LocalDateTime
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

object Utils {
  def factorial(num: Int) :Long = {
    if(num == 1) return 1
    num * factorial(num - 1)
  }

  def isLeapYear(date: String) :Boolean = {
    if(date == null) return false
    val pattern = "yyyy-MM-dd"
    val simpleDateFormat = new SimpleDateFormat(pattern)
    var calendar = Calendar.getInstance
    calendar.setTime((simpleDateFormat.parse(date)))
    isLeapYear(calendar.get(Calendar.YEAR))
  }

  def isLeapYear(date: Date) :Boolean = {
    if(date == null) return false
    var calendar = Calendar.getInstance
    calendar.setTime(date)
    isLeapYear(calendar.get(Calendar.YEAR))
  }

  def isLeapYear(date: sql.Date) :Boolean = {
    if(date == null) return false
    isLeapYear(date.toLocalDate.getYear)
  }

  def isLeapYear(date: LocalDateTime) :Boolean = {
    if(date == null) return false
    isLeapYear(date.getYear)
  }

  def isLeapYear(year: Int) :Boolean = {
    if(year == null) return false
    if(year % 400 == 0) return true
    if(year % 100 == 0) return false
    if(year % 4 == 0) return true
    false
  }
}
