package Intermediate;

import Intermediate.dto.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex7_HighestPaidByDept {
    static void main() {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR",50000),
                new Employee(2, "Bob", "IT",60000),
                new Employee(3, "Charlie", "Account",55000),
                new Employee(4, "David", "IT", 70000)
        );

        Map<String, Optional<Employee>> HighestPaidByDept = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println("Highest Paid Employee by Department: " + HighestPaidByDept);
    }
}
