package Hard;

import java.util.List;
import java.util.stream.IntStream;

// Find the average of every 3 element sliding window in the list.
public class Ex2_SlidingWindowAverage {

    static void main() {

//        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11, 13, 15);
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        int windowSize = 3;

        List<Double> averagesList = IntStream.range(0, (numbers.size() - (windowSize - 1))) // range
                .mapToObj(i -> numbers.subList(i, i + windowSize))  //creates sublists of size windowSize(Ex: [1,3,5], [3,5,7], ... also indexes as(0-2,1-3,2-4,...))
                .map(w -> w.stream()                        // for each sublist calculate average
                        .mapToInt(Integer::intValue)                    // convert to IntStream
                        .average().orElse(0.0))                   // calculate average, if empty return 0.0
                .toList();

        System.out.println("Sliding window averages: " + averagesList);
        //output: Sliding window averages: [9.0, 13.0, 18.0, 27.0]



        /*------------------------------------------------------------------------------------------------------------------------*/
        for (int i = 0; i < (numbers.size() - (windowSize - 1)); i++) {
            List<Integer> window = numbers.subList(i, i + windowSize);
            double average = averagesList.get(i);
            System.out.println("Window: " + window + ", Average: " + average);
        }


    }
}
