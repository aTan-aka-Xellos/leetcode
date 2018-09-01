import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum_1 {

    public static void main(String[] args) {

        test(twoSum(new int[]{2, 7, 11, 15}, 9)[0], 0);
        test(twoSum(new int[]{2, 7, 11, 15}, 9)[1], 1);
    }

    public static int[] twoSum(int[] nums, int target) {

        Integer first;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            first = map.get(target - nums[i]);
            if (first != null && first != i) return new int[]{first, i};
            map.put(nums[i], i);
        }

        int remain;

        for (int j = 0; j < nums.length; j++) {
            remain = target - nums[j];
            first = map.get(remain);
            if (first != null && first != j) return new int[]{j, first};
        }

        return new int[2];
    }

    private static void test(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
