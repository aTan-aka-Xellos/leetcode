package backtracking.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/problems/permutations/discuss/18436/Java-Clean-Code-Two-recursive-solutions/219449
 */
public class Permutations_46 {

    List<List<Integer>> global = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        chose(0, new ArrayList<>(), nums);
        return global;
    }

    void chose(int index, List<Integer> result, int[] nums) {
        if (index == nums.length) {
            global.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = 0; i <= result.size(); i++) {
            result.add(i, nums[index]);
            chose(index + 1, result, nums);
            result.remove(i);
        }
    }
}
    /*
    i=0,[1,2,3] 1 | i=0 [2,3] 2 | i=0 [3] 3
    i=0,[1,2,3] 1 | i=1 [2,3] 3 | i=0 [2] 2

    i=1,[1,2,3] 2 | i=0 [1,3] 1 | i=0 [3] 3
    i=1,[1,2,3] 2 | i=1 [1,3] 3 | i=0 [1] 1

    i=2,[1,2,3] 3 | i=0 [1,2] 1 | i=0 [2] 2
    i=2,[1,2,3] 3 | i=1 [1,2] 2 | i=0 [1] 1

    */
