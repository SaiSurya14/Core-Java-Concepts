package Hard;

import Hard.dto.WorkRecord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Find employees who have worked in at least 3 different departments. */

public class Ex9_EmployeeWith3Dept {
    static void main() {

        List<WorkRecord> workRecords = List.of(
                new WorkRecord("Alice", "HR"),
                new WorkRecord("Bob", "Finance"),
                new WorkRecord("Alice", "IT"),
                new WorkRecord("Alice", "Finance"),
                new WorkRecord("Bob", "IT"),
                new WorkRecord("Charlie", "HR"),
                new WorkRecord("Charlie", "Finance"),
                new WorkRecord("Charlie", "IT")
        );

        Map<String, List<WorkRecord>> groupedList = workRecords.stream()
                .collect(Collectors.groupingBy(WorkRecord::getEmployeeName));

        System.out.println("Grouped List: " + groupedList);

        List<String> entryList = groupedList.entrySet().stream()
                .filter(e -> e.getValue().size() >= 3)
                .map(m -> m.getKey())
                .toList();

        System.out.println("Employees working in at least 3 departments: " + entryList);

        // Output: Employees working in at least 3 departments: [Alice, Charlie]


    }
}
