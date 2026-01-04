package Intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Group strings by their length*/

public class Ex5_GroupingByLength {

    static void main() {
        List<String> fruits = List.of("Apple", "Banana", "Fig", "Grape", "Kiwi", "Mango", "Orange");

        Map<Integer, List<String>> groupByLength = fruits.stream()
                .collect(Collectors.groupingBy(n -> n.length())); // Grouping by length of the string

        // key: length, value: list of strings

        System.out.println("Fruits grouped by length: " + groupByLength);
    }
}
