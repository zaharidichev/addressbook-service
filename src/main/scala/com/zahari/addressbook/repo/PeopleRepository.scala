package com.zahari.addressbook.repo

import com.zahari.addressbook.domain.Person

/**
  *
  * This trait should be mixed in when we want access to the people DTOs
  *
  * Created by zahari on 31/03/2017.
  */
trait PeopleRepository {
  def getAll: Seq[Person]
}
