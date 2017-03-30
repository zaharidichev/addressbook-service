package com.zahari.addressbook

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.zahari.addressbook.endpoint.AddressBookRoutes
import com.zahari.addressbook.service.AddressBookServiceComponent
import org.slf4j.LoggerFactory
import scala.concurrent.ExecutionContext.Implicits.global
import com.zahari.addressbook.repo.FileBasedPeopleRepository

/**
  * This class wires all the default implementations together
  * and binds the routes to the HTTP server.
  *
  * Created by zahari on 30/03/2017.
  */
object AddressBookServiceApp extends App with AddressBookRoutes with AddressBookServiceComponent with FileBasedPeopleRepository {

  private val _logger = LoggerFactory.getLogger(AddressBookServiceApp.getClass)
  implicit val system = ActorSystem("act-system")
  implicit val materializer = ActorMaterializer()
  Http().bindAndHandle(routes, "0.0.0.0", 8080).onComplete(b => _logger.info(s"Binding ${b}"))
}
