package Intermediate;

import Intermediate.dto.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/*Find the highest paid employee in each department*/

public class Ex7_HighestPaidByDept {
    static void main() {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(2, "Bob", "IT", 60000),
                new Employee(3, "Charlie", "Account", 55000),
                new Employee(4, "David", "IT", 70000)
        );

        Map<String, Optional<Employee>> HighestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,   // Grouping by department
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)))); // Finding the highest paid employee in each department

        //key : department, value: highest paid employee in that department

        System.out.println("Highest Paid Employee by Department: " + HighestPaidByDept);

        //output: Highest Paid Employee by Department:
        // {Account=Optional[Employee{id=3, name='Charlie', department='Account', salary=55000}],
        // HR=Optional[Employee{id=1, name='Alice', department='HR', salary=50000}],
        // IT=Optional[Employee{id=4, name='David', department='IT', salary=70000}]}

    }
}
