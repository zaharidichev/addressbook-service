package com.zahari.addressbook.service

import com.zahari.addressbook.domain.Person

/**
  * Created by zahari on 31/03/2017.
  */
trait PeopleRepository {
  def getAll: Seq[Person]
}
