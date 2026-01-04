package Intermediate;

import Intermediate.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Calculate the average salary of employees in each department.

public class Ex6_GroupByEmployeesAndAverageSalary {

    static void main() {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR",50000),
                new Employee(2, "Bob", "IT",60000),
                new Employee(3, "Charlie", "Account",55000),
                new Employee(4, "David", "IT", 70000)
        );

        Map<String, Double> avgSalaryOfDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,  // Grouping by department
                        Collectors.averagingDouble(Employee::getSalary)));  // Calculating average salary in each department

        //key : department, value: average salary

        System.out.println("Average Salary by Department: " + avgSalaryOfDept);

        //output: Average Salary by Department: {Account=55000.0, HR=50000.0, IT=65000.0}
    }


}
