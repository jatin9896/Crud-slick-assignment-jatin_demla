import com.example.connection.H2DBComponent
import com.example.{Employee, EmployeeRepo}
import org.scalatest.AsyncFunSuite


class EmployeeSpec extends AsyncFunSuite {

  object testing extends EmployeeRepo with H2DBComponent
  test("Insert data to employee") {
    testing.insert(Employee(4, "hello",9.0D)).map(x => assert(x == 1))
  }
  test("Upsert data to employee") {
    testing.upsert(Employee(40, "hello",9.0D)).map(x => assert(x == "success"))
  }
  test("Delete data from employee on basis of id") {
    testing.delete(3).map(x=>assert(x==1))

  }

}
