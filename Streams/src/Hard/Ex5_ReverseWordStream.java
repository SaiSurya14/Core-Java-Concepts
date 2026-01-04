package Hard;

import java.util.Arrays;
import java.util.stream.Collectors;

// Reverse the order of words in a given sentence using streams.
public class Ex5_ReverseWordStream {
    static void main() {
        String s = "Java is a popular programming language";
        String collect = Arrays.stream(s.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println("Reversed words: " + collect);

        String c = "Java is a popular programming language";

        String s1 = Arrays.stream(c.split(" "))
                .map(word -> Arrays.stream(word.split(""))
                        .reduce("", (a, b) -> b + a))
                .collect(Collectors.joining(" "));

        System.out.println("Reversed words using reduce: " + s1);

        // Reverse the Line without StringBuilder
        String reduce = Arrays.stream(s.split(""))
                .reduce("", (a, b) -> b + a);

        System.out.println("Reversed line without StringBuilder: " + reduce);

    }
}
