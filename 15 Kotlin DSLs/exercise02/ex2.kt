// Modify the application from exercise 1 
//   - Create an extension function that takes an Employee object and prints all the fields
//     - The function should iterate and print each Project name and department
// Use the DSL and create a collection of Employees
// Iterate through the collection and use your extension function to print Employees


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

fun Employee.prettyPrint() :Unit {
    println("${last}, ${first}  id: ${employeeId}")
    println("  --- Projects ---")
    for( p in projects ) {
        println("  ${p.name} Dept: ${p.department}")
    }
}  

fun main() {
    val employees = arrayListOf( 
        	employee { 
                first = "Bill"
    	    	last = "Young"
	        	employeeId = 5678
		        projects {
    		        project {
            	    	name = "Omaha"
            		    department = "Marketing"
	        	    }
    		        project {
	    	            name = "Quasar"
            	    	department = "Support"
            		}
        		}	
    		},
        	employee { 
                first = "Chelsea"
    	    	last = "Xavier"
	        	employeeId = 7890
		        projects {
    		        project {
            	    	name = "R100"
            		    department = "Design"
	        	    }
        		}	
    		}

    )
    
    for( e in employees ) e.prettyPrint()
}