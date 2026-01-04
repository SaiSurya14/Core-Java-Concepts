package Intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex3_PartitionEvenOdd {

    static void main() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // how Partitioning works internally is that it creates a Map with two keys: true and false.
        // The key 'true' maps to a list of elements that satisfy the predicate (even numbers in this case),
        // while the key 'false' maps to a list of elements that do not satisfy the predicate (odd numbers in this case).

        System.out.println("Even Numbers: " + evenOddMap.get(true));
        System.out.println("Odd Numbers: " + evenOddMap.get(false));

        // Even Numbers: [2, 4, 6, 8, 10]
        // Odd Numbers: [1, 3, 5, 7, 9
    }
}
