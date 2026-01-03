package Intermediate;

import Intermediate.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex1_SortEmployeesBySalary {
    static void main() {

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice", "HR",50000),
                new Employee(2, "Bob", "IT",60000),
                new Employee(3, "Charlie", "Account",55000),
                new Employee(4, "David", "IT", 70000)
        );

        List<Employee> list = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.printf("Sorted Employees by Salary: %s%n", list);


    }
}
