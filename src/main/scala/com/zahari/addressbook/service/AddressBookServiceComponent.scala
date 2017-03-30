package com.zahari.addressbook.service

import com.zahari.addressbook.domain.Person

/**
  * Created by zahari on 31/03/2017.
  */
trait AddressBookServiceComponent { repo: PeopleRepository =>

  val service = new DefaultAddressBookService

  class DefaultAddressBookService extends AddressBookService {
    override def numberOfMales: Int = ???

    override def oldestPerson: Person = ???

    override def ageDifferenceInDays(n1: String, n2: String): Int = ???
  }

}
