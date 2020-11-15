package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII_47 {

    List<List<Integer>> global = new ArrayList<>();

    // 11/13/2020
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> from = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(from, new ArrayList<>());
        return global;
    }

    private void backtrack(List<Integer> from, List<Integer> perm) {
        if (from.isEmpty()) {
            global.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < from.size(); i++) {
            if (i > 0 && from.get(i) == from.get(i - 1)) continue;

            // choose the candidate
            perm.add(from.remove(i));

            backtrack(from, perm);

            // un-choose the candidate
            from.add(i, perm.remove(perm.size() - 1));
        }
    }
}
