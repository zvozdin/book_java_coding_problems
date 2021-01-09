package chapter1_strings_number_math;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharactersCounting {

    public static Map<Character, Integer> duplicateCharactersCounting(String string) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (result.containsKey(character)) {
                Integer integer = result.get(character);
                result.put(character, ++integer);
            } else {
                result.put(character, 1);
            }
        }

        return result;
    }

    public static Map<Character, Integer> duplicateCharactersCountingWithMapCompute(String string) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Character character : string.toCharArray()) {
//            https://javarush.ru/groups/posts/524-khvatit-pisatjh-ciklih-top-10-luchshikh-metodov-dlja-rabotih-s-kollekcijami-iz-java8
            result.compute(character, (a, b) -> (b == null) ? 1 : ++b);
        }

        return result;
    }

    public static Map<Character, Long> duplicateCharactersCountingByStream(String string) {
//              Call the String.chars() method on the original string. This will
//        return IntStream. This IntStream contains an integer representation of
//        the characters from the given string.
//              Transform IntStream into a stream of characters via the mapToObj()
//        method (convert the integer representation into the human-friendly
//        character form).
//              Finally, group the characters (Collectors.groupingBy()) and count
//        them (Collectors.counting()).
        return string.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
    }

}
