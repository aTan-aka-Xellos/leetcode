package others.medium;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber_287 {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            if (nums[nums[i]] == nums[i]) return nums[i];
            swap(nums, nums[i], i);
            i--;
        }
        return -1;
    }

    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
