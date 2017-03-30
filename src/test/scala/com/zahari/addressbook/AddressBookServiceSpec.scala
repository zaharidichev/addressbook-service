package com.zahari.addressbook

import com.github.nscala_time.time.Imports.LocalDate
import com.zahari.addressbook.domain.{Female, Male, Person}
import com.zahari.addressbook.service.{AddressBookServiceComponent, PeopleRepository}
import org.scalatest.FlatSpec

/**
  * Created by zahari on 31/03/2017.
  */
class AddressBookServiceSpec extends FlatSpec {

  val serviceWithMockedRepo = new AddressBookServiceComponent with PeopleRepository {
    override def getAll = Seq(
      Person("Zahari", "Dichev", Male, LocalDate.now()),
      Person("John", "Fox", Male, LocalDate.now().minusDays(1)),
      Person("Gloria", "Wang", Female, LocalDate.now().plusDays(1))
    )
  }

}
