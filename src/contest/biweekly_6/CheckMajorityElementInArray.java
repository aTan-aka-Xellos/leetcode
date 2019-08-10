package contest.biweekly_6;

/**
 * https://leetcode.com/contest/biweekly-contest-6/problems/is-a-a-majority-element
 */
public class CheckMajorityElementInArray {

    public boolean isMajorityElement(int[] nums, int target) {

        int count = 0;

        for (int num : nums) {
            if (num == target) count++;
        }

        return count > (nums.length / 2);
    }
}
