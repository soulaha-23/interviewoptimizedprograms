import java.util.*;

public class SecondHighest {

    public static Integer findSecondHighest(List<Integer> numbers) {

        return numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    public static Integer secondHighest(List<Integer> numbers) {

        Integer max = null;
        Integer second = null;

        for (Integer n : numbers) {

            if (n == null) {
                continue;
            }

            if (max == null || n > max) {
                second = max;
                max = n;
            } else if (n < max && (second == null || n > second)) {
                second = n;
            }
        }

        return second;
    }

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 30, 20, 30, 40, 50);

        System.out.println(findSecondHighest(numbers));
        System.out.println(secondHighest(numbers));
    }
}
