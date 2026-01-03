package Intermediate;

import Intermediate.dto.Person;

import java.util.List;

public class Ex2_AverageAge {
    static void main() {

        List<Person> personList = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 40)
        );

        double averageAge = personList.stream().mapToDouble(Person::getAge).average().orElse(0.0);
        System.out.println("Average Age: " + averageAge);
    }
}
