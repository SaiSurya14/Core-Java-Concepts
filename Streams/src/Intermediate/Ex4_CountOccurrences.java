package Intermediate;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex4_CountOccurrences {

    static void main() {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> occurrences = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Item occurrences: " + occurrences);
    }
}
