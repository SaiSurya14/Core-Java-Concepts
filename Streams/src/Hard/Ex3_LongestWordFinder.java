package Hard;

import java.util.Arrays;
import java.util.Comparator;

public class Ex3_LongestWordFinder {
    static void main() {
        String text = "In computer science, a stream is a sequence of data elements made available over time.";
        String s = Arrays.stream(text.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" "))
                .max(Comparator.comparing(String::length)).orElse(" ");

        System.out.println("Longest word: " + s);
    }
}
