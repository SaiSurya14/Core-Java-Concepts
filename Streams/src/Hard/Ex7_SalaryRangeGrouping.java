package Hard;

import Hard.dto.Employee;
import Hard.dto.SalaryRange;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex7_SalaryRangeGrouping {
    static void main() {

        List<Employee> employees = List.of(
                new Employee("Alice", 55000),
                new Employee("Bob", 72000),
                new Employee("Charlie", 48000),
                new Employee("David", 100000),
                new Employee("Eve", 66000)
        );

        Map<SalaryRange, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> getSalaryRange(e.getSalary())));
        System.out.println("Employees grouped by Salary Range: " + collect);

    }

    private static SalaryRange getSalaryRange(double salary) {
        if (salary < 50000) return SalaryRange.LOW;
        else if (salary <= 80000) return SalaryRange.MEDIUM;
        else return SalaryRange.HIGH;
    }

}
