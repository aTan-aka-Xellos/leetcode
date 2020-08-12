package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursion solution for:
 * https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/1660
 */
public class PascalsTriangle_II_118 {

    public List<Integer> _getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(Arrays.asList(1));

        if (rowIndex > 0) {
            List<Integer> top = getRow(rowIndex - 1);

            for (int i = 1; i < rowIndex; i++) {
                result.add(top.get(i - 1) + top.get(i));
            }
            result.add(1);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> current = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            current.clear();
            for (int j = 0; j <= prev.size() && j <= rowIndex; j++) {
                if (j == 0 || j == prev.size()) current.add(1);
                else current.add(prev.get(j - 1) + prev.get(j) );
            }
            prev = new ArrayList<>(current);
        }
        return current;
    }

}
