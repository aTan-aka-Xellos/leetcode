package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * https://backtobackswe.com/platform/content/generate-the-powerset/code
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void generate(int[] nums,
                  int index,
                  List<Integer> subset,
                  List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(subset);
            return;
        }

        List<Integer> subsetRight = new ArrayList<>(subset);
        subsetRight.add(nums[index]);

        generate(nums, index + 1, subset, ans);
        generate(nums, index + 1, subsetRight, ans);
    }
}
