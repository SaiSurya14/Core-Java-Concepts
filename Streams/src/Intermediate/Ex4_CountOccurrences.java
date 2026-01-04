package Intermediate;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex4_CountOccurrences {

    // Count occurrences of each item in a list using groupingBy and counting collectors

    static void main() {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> occurrences = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // How groupingBy works here:
        // 1. Function.identity() returns the item itself as the key.
        // 2. Collectors.counting() counts how many times each key appears in the stream.
        // The result is a Map where keys are the items and values are their counts.
        //Key: "apple", Value: 3 (appears 3 times) : {"apple"=3, "banana"=2, "orange"=1}

        System.out.println("Item occurrences: " + occurrences);

        //Output: Item occurrences: {orange=1, banana=2, apple=3}
    }
}
