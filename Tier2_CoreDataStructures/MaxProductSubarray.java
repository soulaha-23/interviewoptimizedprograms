public class MaxProductSubarray {

    public static int maxProduct(int[] arr) {

        int max = arr[0];
        int min = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int value = arr[i];

            if (value < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(value, max * value);
            min = Math.min(value, min * value);

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};

        System.out.println(maxProduct(arr));
    }
}
