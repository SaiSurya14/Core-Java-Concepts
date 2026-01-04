package Intermediate;

import Intermediate.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Find all Departments with more than 2 Employees*/

public class Ex8_DepartmentEmployeeCount {
    static void main() {

        List<Employee> employeeList = List.of(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(2, "Bob", "IT", 60000),
                new Employee(3, "Charlie", "Account", 55000),
                new Employee(4, "David", "IT", 70000),
                new Employee(6, "Frank", "Account", 58000),
                new Employee(7, "Grace", "IT", 72000),
                new Employee(8, "Hannah", "IT", 52000)
        );

        Map<String, Long> employeeCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));   // Grouping by department and counting employees in each department

        System.out.println("Employee Count by Department: " + employeeCount);

        List<String> list = employeeCount.entrySet().stream()
                .filter(e -> e.getValue() > 2)  // Filtering departments with more than 2 employees
                .map(Map.Entry::getKey)   // Extracting department names
                .toList();
        //key : department, value: count of employees

        System.out.println("Departments with more than 2 Employees: " + list);
        // output: Departments with more than 2 Employees: [IT]

    }
}
