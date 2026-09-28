import java.util.*;
import java.util.stream.*;

public class FindDuplicates {

    public static List<Integer> findDuplicatesStream(List<Integer> numbers) {

        return IntStream.range(0, numbers.size())
                .mapToObj(numbers::get)
                .filter(n ->
                        Collections.frequency(numbers, n) > 1)
                .distinct()
                .toList();
    }

    public static Set<Integer> findDuplicatesOptimized(List<Integer> numbers) {

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer n : numbers) {
            if (!seen.add(n)) {
                duplicates.add(n);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 1);

        System.out.println(findDuplicatesStream(numbers));
        System.out.println(findDuplicatesOptimized(numbers));
    }
}
