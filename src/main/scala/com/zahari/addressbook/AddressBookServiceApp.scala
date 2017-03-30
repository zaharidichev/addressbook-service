package com.zahari.addressbook

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.zahari.addressbook.domain.Person
import com.zahari.addressbook.endpoint.AddressBookRoutes
import com.zahari.addressbook.service.{AddressBookServiceComponent, PeopleRepository}
import org.slf4j.LoggerFactory
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by zahari on 30/03/2017.
  */
object AddressBookServiceApp extends App with AddressBookRoutes with AddressBookServiceComponent with PeopleRepository {

  private val _logger = LoggerFactory.getLogger(AddressBookServiceApp.getClass)
  implicit val system = ActorSystem("act-system")
  implicit val materializer = ActorMaterializer()
  Http().bindAndHandle(routes, "0.0.0.0", 8080).onComplete(b => _logger.info(s"Binding ${b}"))

  override def getAll: Seq[Person] = Seq()
}
