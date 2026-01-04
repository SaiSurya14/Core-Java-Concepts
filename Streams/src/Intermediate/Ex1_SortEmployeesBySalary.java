package Intermediate;

import Intermediate.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Sorting Employees by Salary in Ascending Order */

public class Ex1_SortEmployeesBySalary {
    static void main() {

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice", "HR",50000),
                new Employee(2, "Bob", "IT",60000),
                new Employee(3, "Charlie", "Account",55000),
                new Employee(4, "David", "IT", 70000)
        );

        List<Employee> list = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))  // Sorting by salary in ascending order
                .toList();

        System.out.printf("Sorted Employees by Salary: %s%n", list);

        //output: [Employee{id=1, name='Alice', department='HR', salary=50000}, Employee{id=3, name='Charlie', department='Account', salary=55000}, Employee{id=2, name='Bob', department='IT', salary=60000}, Employee{id=4, name='David', department='IT', salary=70000}]


    }
}
