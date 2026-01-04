package Intermediate;

import Intermediate.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Find the department with the highest average salary*/

public class Ex9_HighestAvgSalaryDept {
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

        Map.Entry<String, Double> max = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, // key: department and value: average salary
                                Collectors.averagingDouble(Employee::getSalary))) // First it will group the departments and calculate average salary
                .entrySet().stream().max(Map.Entry.comparingByKey()).orElseThrow(); // Then it will find the max average salary department

        //key : department, value: average salary
        // Time Complexity: O(n)

        System.out.println("Department with Highest Average Salary: " + max.getKey());

        // output: Department with Highest Average Salary: IT
    }
}
