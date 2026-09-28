public class MoveZeros {

    public static void moveZeros(int[] arr) {

        int index = 0;

        for (int n : arr) {

            if (n != 0) {
                arr[index++] = n;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 0, 1, 0, 1, 2, 0, 6};

        moveZeros(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }
}
