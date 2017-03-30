package com.zahari.addressbook

import com.zahari.addressbook.repo.PeopleRepository
import com.zahari.addressbook.service.AddressBookServiceComponent
import org.scalatest.FlatSpec

/**
  * Created by zahari on 31/03/2017.
  */
class EmptyAddressBookServiceSpec extends FlatSpec {

  val serviceWithEmptyMockedRepo = new AddressBookServiceComponent with PeopleRepository {
    override def getAll = Seq()
  }.service

  "numberOfMales" should "return 0" in {
    assert(serviceWithEmptyMockedRepo.numberOfMales == 0)
  }

  "oldestPerson" should "return be an empty option" in {
    assert(serviceWithEmptyMockedRepo.oldestPerson.isEmpty)

  }

  "age difference between John and Gloria" should "be an empty option" in {
    assert(serviceWithEmptyMockedRepo.ageDifferenceInDays("John", "Gloria").isEmpty)

  }

}
