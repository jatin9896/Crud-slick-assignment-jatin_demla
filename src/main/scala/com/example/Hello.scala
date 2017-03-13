package com.example

import scala.concurrent.ExecutionContext.Implicits.global

object Hello {

  //
  def main(args: Array[String]): Unit = {
  /*  EmployeeRepo.create
    val insertRes = EmployeeRepo.insert(Employee(807, "ankit", 4.0D))
    Thread.sleep(1000)
    val res = insertRes.map { res => s"$res row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }
    res.map(println(_))
    Thread.sleep(1000)
    ProjectRepo.create
    val insertproj=ProjectRepo.insert(Project(901,"proj1","807"))
    Thread.sleep(1000)
    val resproj = insertproj.map { res => s"$res row inserted in project table" }.recover {
      case ex: Throwable => ex.getMessage
    }
    resproj.map(println(_))
    Thread.sleep(1000)
    val depend=DependentRepo.insert(Dependent(807,"asket","brother",50))
    Thread.sleep(1000)
    val depnd= depend.map{res => s"$res row inserted in dependent"}.recover {
      case ex: Throwable => ex.getMessage
    }
   depend.map(println(_))
    Thread.sleep(1000)*/
    ProjectRepo.create
    val all=ProjectRepo.getAll
    Thread.sleep(1000)
    all.map(x=>x.map(print _ ))
    val findindex=ProjectRepo.find(21)
    Thread.sleep(1000)
    findindex.map(println(_))
  }

}
