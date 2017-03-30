package com.zahari.addressbook.repo

import scala.io.Source
import com.github.nscala_time.time.Imports._
import com.zahari.addressbook.domain.{Female, Male, Person, Undetermined}

/**
  * Created by zahari on 31/03/2017.
  */
trait FileBasedPeopleRepository extends PeopleRepository {

  private val formatter = DateTimeFormat.forPattern("d/M/YY")

  override val getAll: Seq[Person] = {

    def toPerson(l: String) = {

      l.trim.split(", ") match {
        case Array(firstLastName, gender, dateOfBirth) => {
          val fn = firstLastName.split(' ')(0)
          val ln = firstLastName.split(' ')(1)
          val gn = gender match {
            case "Male" => Male
            case "Female" => Female
            case _ => Undetermined
          }
          val dob = LocalDate.parse(dateOfBirth, formatter)
          Person(fn, ln, gn, dob)
        }
      }

    }

    (Source.fromURL(getClass.getResource("/AddressBook")).getLines() map toPerson).toSeq

  }

}
