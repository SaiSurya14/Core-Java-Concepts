package Hard;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the top 3 most frequent words in a given text.
public class Ex4_FindTop3FreqWords {
    static void main() {
        String paragraph = "In computer science, a stream is a sequence of data elements made available over time. " +
                "Streams are used to handle data that is produced or consumed at different rates. " +
                "streams provide a way to process data in a functional style.";

        Map<String, Long> stringLongMap = Arrays.stream(paragraph.toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(stringLongMap);
        List<Map.Entry<String, Long>> list = stringLongMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();
        System.out.println("Top 3 most frequent words: " + list);


    }
}
