package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * https://backtobackswe.com/platform/content/generate-the-powerset/code
 */
public class Subsets_78 {

    List<List<Integer>> global = new ArrayList<>();

    // 02/01/2021
    public List<List<Integer>> subsets_v2(int[] nums) {
        bt(new ArrayList<>(), nums, 0);
        return global;
    }

    void bt(List<Integer> curr, int[] nums, int idx) {
        if (idx == nums.length) {
            global.add(new ArrayList<>(curr));
            return;
        }

        bt(curr, nums, idx + 1);
        curr.add(nums[idx]);
        bt(curr, nums, idx + 1);
        curr.remove(curr.size() - 1);
    }


    // 07/12/2020
    public List<List<Integer>> subsets_v1(int[] nums) {
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
