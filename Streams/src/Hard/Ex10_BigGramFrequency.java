package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex10_BigGramFrequency {
    static void main() {

        String s = "Java is great and Java is fun. I love Java!";

        // Preprocess the string: convert to lowercase, remove punctuation, and split into words
        String[] split = s.toLowerCase().replaceAll("[^a-z\\s}]", "")
                .split(" ");
        System.out.println("split = " + Arrays.toString(split));

        // Create the bigrams list
        List<String> list = IntStream.range(0, split.length - 1)
                .mapToObj(i -> split[i] + " " + split[i + 1])
                .toList();
        System.out.println("list = " + list);

        // Count the frequency of each bigram
        Map<String, Long> stringLongMap = list.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Bigram frequencies: " + stringLongMap);

        // Filter and display bigrams that occur 2 or more times
        List<Map.Entry<String, Long>> list1 = stringLongMap.entrySet().stream().filter(w -> w.getValue() >= 2).toList();
        System.out.println("Frequent bigrams (occurring 2 or more times): " + list1);

        // Find the most frequent bigram
        Map.Entry<String, Long> stringLongEntry = stringLongMap.entrySet().stream().max(Comparator.comparing(e -> e.getValue())).orElseThrow();
        System.out.println("Most frequent bigram: " + stringLongEntry.getKey());

    }
}
