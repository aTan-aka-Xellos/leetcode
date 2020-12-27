package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursion solution for:
 * https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/1659
 */
public class PascalsTriangle_118 {

    // 12/22/2020
    public List<List<Integer>> generate_v1(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> prev = null;

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            list.add(curr);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) curr.add(1);
                else curr.add(prev.get(j - 1) + prev.get(j));
            }
            prev = curr;
        }
        return list;
    }

    // 08/07/2019
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows > 0) generateRow(numRows);
        return result;
    }

    private List<Integer> generateRow(int length) {
        List<Integer> current = new ArrayList<>(Arrays.asList(1));

        if (length > 1) {
            List<Integer> top = generateRow(length - 1);
            for (int i = 1; i < length - 1; i++) {
                current.add(top.get(i - 1) + top.get(i));
            }
            current.add(1);
        }
        result.add(current);
        return current;
    }
}
