package arrays.easy;

public class MaxConsecutiveOnes_485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else
                count = 0;
        }
        return max;
    }
}
