package com.example

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile


trait GenericDB {

  val driver:JdbcProfile;
  import driver.api._
  val db: Database;
}
