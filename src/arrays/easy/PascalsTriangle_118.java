package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursion solution for:
 * https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/1659
 */
public class PascalsTriangle_118 {

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
