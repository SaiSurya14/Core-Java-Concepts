package Intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex5_GroupingByLength {

    static void main() {
        List<String> fruits = List.of("Apple", "Banana", "Fig", "Grape", "Kiwi", "Mango", "Orange");

        Map<Integer, List<String>> groupByLength = fruits.stream().collect(Collectors.groupingBy(n -> n.length()));
        System.out.println("Fruits grouped by length: " + groupByLength);

//        fruits.stream().collect(Collectors.groupingBy(n -> n.startsWith()))
    }
}
