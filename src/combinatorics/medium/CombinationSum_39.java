package combinatorics.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 * Important:
 * - why sort is needed?
 * - pass 'start' to avoid duplicates,
 *   but pass i, not i + 1 to the next level
 *
 * negative base case
 * base case
 *
 * choose
 * recursion
 * un-choose
 */

public class CombinationSum_39 {

    List<List<Integer>> global = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dive(new ArrayList<>(), nums, target, 0);
        return global;
    }

    private void dive(List<Integer> local, int[] nums, int target, int start) {
        if (target <  0)  return;
        if (target == 0)  { global.add(new ArrayList<>(local)); return; }

        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            local.add(nums[i]);
            dive(local, nums, target - nums[i], i);
            local.remove(local.size() - 1);
        }
    }
}
