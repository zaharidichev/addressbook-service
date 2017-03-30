package com.zahari.addressbook.domain

import com.github.nscala_time.time.Imports._

/**
  * Created by zahari on 30/03/2017.
  */
sealed trait Gender
case object Male extends Gender
case object Female extends Gender

case class Person(firstName: String, lastName: String, gender: Gender, dateOfBirth: LocalDate)
