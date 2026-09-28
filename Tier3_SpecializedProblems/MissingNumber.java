public class MissingNumber {

    public static int findMissing(int[] nums) {

        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        System.out.println(findMissing(nums));
    }
}
