package playground

import scala.concurrent.Future

case class Department(id: String, name: String, employeeIds: List[String])

case class Employee(id: String, name: String)

case class DepartmentWithEmployees(departmentId: String, departmentName: String, employees: List[Employee])

object DepartmentService {
  def getDepartment(id: String): Future[Option[Department]] = ???
}

object EmployeeService {
  def getEmployee(id: String): Future[Option[Employee]] = ???
}

object DepartmentWithEmployeesService {
  import scala.concurrent.ExecutionContext.Implicits.global
  import DepartmentService.getDepartment
  import EmployeeService.getEmployee

  import cats.data.OptionT
  import cats.implicits._

  def getDepartmentWithEmployees(departmentId: String): Future[Option[DepartmentWithEmployees]] =
    (for {
      department <- OptionT(getDepartment(departmentId))
      employeeList <- OptionT(department.employeeIds.map(getEmployee).sequence.map(_.sequence))
    } yield DepartmentWithEmployees(departmentId, department.name, employeeList)).value
}

