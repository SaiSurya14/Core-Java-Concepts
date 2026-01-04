package Intermediate;


/*Find the first non-repeating character in a string*/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex11_FirstNonRepeatingChar {
    static void main() {
        String input = "swiss";

        Map.Entry<Character, Long> characterLongEntry = input.chars()  //converts to IntStream(ASCII values)
                .mapToObj(c -> (char) c) //converts to Stream<Character>(Character objects)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())) //creates Map<Character, Long>(returns like {'s'=3, 'w'=1, 'i'=1})
                .entrySet().stream()
                .filter(c -> c.getValue() == 1) //filters entries with value 1 (non-repeating characters)
                .findFirst().orElseThrow();

        System.out.println("First non-repeating character: " + characterLongEntry.getKey());
        // Output: First non-repeating character: w


        // Above Code groupingBy does not guarantee the order of characters. because it uses HashMap internally.
        // To maintain insertion order, we can use LinkedHashMap as shown below:
        Map.Entry<Character, Long> firstNonRepeatingChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,     // Using LinkedHashMap to preserve insertion order
                        Collectors.counting())) // creates LinkedHashMap<Character, Long> (like {'s'=3, 'w'=1, 'i'=1})
                .entrySet().stream()
                .filter(c -> c.getValue() == 1)
                .findFirst().orElseThrow();

        System.out.println("First non-repeating character (using LinkedHashMap): " + firstNonRepeatingChar.getKey());
        // Output: First non-repeating character (using LinkedHashMap): w
    }
}
