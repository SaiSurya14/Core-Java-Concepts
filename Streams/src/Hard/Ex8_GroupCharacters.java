package Hard;

import Hard.dto.CharCategory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex8_GroupCharacters {
    static void main() {
        List<Character> characters = List.of('A', 'b', 'C', '1', '@', 'd', 'E', '3', '#', 'f');

        Map<Object, List<Character>> collect = characters.stream()
                .collect(Collectors.groupingBy(c -> getCharacterType(c)));

        System.out.println("Characters grouped by type: " + collect);

        String s = "Hello World! 123";

        Map<Object, List<Character>> stringCharacters = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(g -> getCharacterType(g)));
        System.out.println("String characters grouped by type: " + stringCharacters);
    }

    private static Object getCharacterType(Character c) {
        if (Character.isUpperCase(c)) {
            return CharCategory.UPPERCASE;
        } else if (Character.isLowerCase(c)) {
            return CharCategory.LOWERCASE;
        } else if (Character.isDigit(c)) {
            return CharCategory.DIGIT;
        } else {
            return CharCategory.SPECIAL;
        }

    }


}
