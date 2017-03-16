import com.example.{Employee, ProjectRepo, Project}
import com.example.connection.H2DBComponent
import org.scalatest.AsyncFunSuite


class ProjectSpec extends AsyncFunSuite {
  object testing extends ProjectRepo with H2DBComponent
  test("Insert data in project"){
    testing.insert(Project(4, "hello",2)).map(res => assert(res == 1))
  }
  test ("Get all employee with project name"){
    testing.getAllProjectWithEmployee.map(res=>assert(res===List(("proj1","emp1"),("proj2","emp2"))))
  }
  test("Upsert data to project") {
    testing.upsert(Project(40, "hello",3)).map(res => assert(res == "success"))
  }
  test("Find data from project on basis of id") {
    testing.find(3).map(x => assert(x === None))
  }
  test("insert and then update"){
    testing.insertThenUpdate(Project(50,"proj50",2)).map(res=> assert(res==1))
  }
  test("update Mame"){
    testing.updateName(2,"newproj").map(res=>assert(res==1))
  }
  test("insertion using plain sql"){
    testing.insertUsingPlainSql(Project(23,"proj23",2)).map(res=>assert(res==1))
  }
}
