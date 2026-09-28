import java.util.*;

public class FirstNonRepeating {

    public static Character findFirst(String str) {

        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static Character findFirstStream(String str) {

        return str
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.chars()
                        .mapToObj(x -> (char) x)
                        .filter(x -> x == c)
                        .count() == 1)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(findFirst("Swiss"));
        System.out.println(findFirstStream("Swiss"));
    }
}
