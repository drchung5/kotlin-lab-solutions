// Create a Kotlin DSL that allows you to create an Employee object. 
//   - Employees have firstName, lastName, and employeeID
//   - Employees have zero or more Projects
//   - Projects have a name and and department

data class Employee( val first :String, val last :String, val employeeId :Int, val projects :List<Project> )
data class Project( val name :String, val department :String )

class EmployeeBuilder {
    var first :String = ""
    var last :String = "" 
    var employeeId :Int = 0
    private val projects = mutableListOf<Project>() 
    
    fun projects(action :Projects.() -> Unit) {
        projects.addAll(Projects().apply(action))    
    }
    
    fun build() :Employee = Employee(first, last, employeeId, projects)
}

class ProjectBuilder {
    var name :String = ""
    var department :String = ""
    
    fun build() :Project = Project(name, department)
}

class Projects :ArrayList<Project>() {
    fun project(action :ProjectBuilder.() -> Unit) {
        add(ProjectBuilder().apply(action).build())
    }
}

fun employee(action :EmployeeBuilder.() -> Unit) :Employee = EmployeeBuilder().apply(action).build()

fun main() {
    val employee = employee {
        first = "Ann"
        last = "Zolo"
        employeeId = 1123
        projects {
            project {
                name = "Green Machine"
                department = "Engineering"
            }
            project {
                name = "StarPhoenixgate"
                department = "Services"
            }
        }
    }
}
