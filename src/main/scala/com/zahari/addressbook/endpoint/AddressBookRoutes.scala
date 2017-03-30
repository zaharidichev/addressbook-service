package com.zahari.addressbook.endpoint

import com.zahari.addressbook.service.{AddressBookService, AddressBookServiceComponent}
import akka.http.scaladsl.server.Directives._
import com.zahari.addressbook.domain.Response

/**
  * Created by zahari on 31/03/2017.
  */
trait AddressBookRoutes extends JsonSupport {

  val service: AddressBookService

  val routes = path("number-males") {
    get {
      complete {
        Response(s"The number of males is ${service.numberOfMales}")
      }

    }
  } ~
    path("oldest-person") {
      get {
        complete {
          Response(s"The oldest person is ${service.oldestPerson.map(_.firstName).getOrElse("nobody as the address book is empty")}")
        }
      }
    } ~
    path("bill-and-paul-age-diff") {
      get {
        complete {
          val daysBillIsOlderThanPaul = service
            .ageDifferenceInDays("Bill", "Paul")
            .getOrElse("unknown amount of days as one of them is not in the address book")
          Response(s"The number of days by which Bill is older than Paul is $daysBillIsOlderThanPaul")
        }
      }
    }

}
