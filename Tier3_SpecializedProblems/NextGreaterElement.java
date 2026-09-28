import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {

        int[] result = new int[arr.length];

        Arrays.fill(result, -1);

        Deque<Integer> stack =
                new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty()
                    && arr[i] > arr[stack.peek()]) {

                result[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10, 8};

        System.out.println(
                Arrays.toString(nextGreater(arr))
        );
    }
}
