package com.zahari.addressbook.endpoint
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.zahari.addressbook.domain.Response
import spray.json.DefaultJsonProtocol

/**
  * Created by zahari on 31/03/2017.
  */
trait JsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val responseFormat = jsonFormat1(Response)
}
