package com.zahari.addressbook.service

import com.zahari.addressbook.domain.Person

/**
  * Created by zahari on 30/03/2017.
  */
trait AddressBookService {
  def numberOfMales: Int
  def oldestPerson: Option[Person]
  def ageDifferenceInDays(n1: String, n2: String): Option[Int]
}
