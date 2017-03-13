package com.example


import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future


case class Project(pid: Int, pname: String)

trait ProjectTable extends EmployeeTable {

  val projectTableQuery = TableQuery[ProjectTable]

  class ProjectTable(tag: Tag) extends Table[Project](tag, "project") {

    val pid = column[Int]("pid")
    val pname = column[String]("pname")

    def employeeProjectFK = foreignKey("emp_proj_fk", pid, employeeTableQuery)(_.id)

    def * = (pid, pname) <>(Project.tupled, Project.unapply)
  }

}

trait ProjectRepo extends ProjectTable {
  this: GenericDB =>

  import driver.api._

  // val db=Database.forConfig("myPostgresDB")
  def create: Future[Unit] = db.run(projectTableQuery.schema.create)

  def insert(project: Project): Future[Int] = db.run {
    projectTableQuery += project
  }
  def getAll: Future[List[Project]] = {
    db.run { projectTableQuery.to[List].result}
  }
  def find(id: Int): Future[Option[Project]] =
    db.run((for (project <- projectTableQuery if project.pid === id) yield project).result.headOption)
  def upsert(project: Project): String ={
    val search=find(project.pid)
    search.map(x=> x match {
      case Some(i) => updateName(i.pid, i.pname)
      case _ => insert(project)
    }
    )
    "success"
  }
  def updateName(id: Int, name: String): Future[Int] = {
    val query = projectTableQuery.filter(_.pid === id).map(_.pname).update(name)
    db.run(query)
  }

}

object ProjectRepo extends ProjectRepo with SqlDb