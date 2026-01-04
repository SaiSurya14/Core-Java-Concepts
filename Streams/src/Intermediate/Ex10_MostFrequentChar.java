package Intermediate;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex10_MostFrequentChar {
    static void main() {
        String input = "banana";

        Map.Entry<Character, Long> characterLongEntry = input.chars()  //converts to IntStream(ASCII values)
                .mapToObj(c -> (char) c)   //converts to Stream<Character>(Character objects)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())) //creates Map<Character, Long>(returns like {'b'=1, 'a'=3, 'n'=2})
                .entrySet().stream()  //creates Stream<Map.Entry<Character, Long>>(we do this again to process the map entries)
                .max(Map.Entry.comparingByValue()).orElseThrow();  //finds the entry with max value(Long) and returns Map.Entry<Character, Long>

        //Key: Character, Value: Long (frequency of character in the string)

        System.out.println("Most frequent character: " + characterLongEntry.getKey());

    }
}
