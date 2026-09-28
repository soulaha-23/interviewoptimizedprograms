import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static void main(String[] args) {

        String str = "banana";

        Map<Character, Long> result =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ));

        System.out.println(result);
    }
}
