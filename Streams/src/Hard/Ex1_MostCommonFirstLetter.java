package Hard;

import Intermediate.dto.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/* Find the most common first letter among employee names. */

public class Ex1_MostCommonFirstLetter {
    static void main() {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", "HR", 50000),
                new Employee(3, "Charlie", "Account", 55000),
                new Employee(4, "David", "IT", 70000),
                new Employee(5, "Amanda", "Marketing", 52000),
                new Employee(6, "Brian", "Sales", 58000)
        );

        Optional<Map.Entry<Character, Long>> max = employees.stream().
                map(c -> c.getName().charAt(0)) // Get first letter from name of each employee
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))// Count occurrences of each first letter(returns like A=2, B=1, C=1, D=1)
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());  // Get the entry with the maximum value

        System.out.println("Most Common First Letter: " + max);

        //output: Most Common First Letter: Optional[A=2]
    }
}
