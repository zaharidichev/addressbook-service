package com.zahari.addressbook.service
import scala.util.Try
import com.github.nscala_time.time.Imports._
import com.zahari.addressbook.domain.{Male, Person}
import org.joda.time.Days

/**
  * Created by zahari on 31/03/2017.
  */
trait AddressBookServiceComponent { repo: PeopleRepository =>

  val service = new DefaultAddressBookService

  class DefaultAddressBookService extends AddressBookService {
    override def numberOfMales: Int = repo.getAll.count(_.gender == Male)

    override def oldestPerson: Option[Person] = Try(repo.getAll.minBy(_.dateOfBirth)).toOption

    override def ageDifferenceInDays(n1: String, n2: String): Option[Int] = {
      val nameToPerson = repo.getAll.map(p => p.firstName -> p).toMap
      for {
        person1 <- nameToPerson.get(n1)
        person2 <- nameToPerson.get(n2)
      } yield Days.daysBetween(person1.dateOfBirth, person2.dateOfBirth).getDays

    }
  }

}
