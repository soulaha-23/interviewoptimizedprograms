import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(
            int[] a,
            int[] b) {

        int i = a.length - 1;
        int j = 0;

        while (i >= 0 && j < b.length) {

            if (a[i] > b[j]) {

                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;

                i--;
                j++;

            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7};
        int[] b = {0, 2, 6, 8, 9};

        merge(a, b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
