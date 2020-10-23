package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle_120 {

    // https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution
    public int minimumTotal_v2(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public int minimumTotal_v1(List<List<Integer>> triangle) {
        List<List<Integer>> sum = new ArrayList<>();

        sum.add(Arrays.asList(triangle.get(0).get(0)));
        List<Integer> prevSumLine = sum.get(0);

        for (int i = 1; i < triangle.size(); i++) {
            sum.add(new ArrayList<>());
            List<Integer> line = triangle.get(i);

            sum.get(i).add(line.get(0) + prevSumLine.get(0));

            for (int j = 1; j < line.size() - 1; j++) {
                sum.get(i).add(line.get(j) + Math.min(prevSumLine.get(j), prevSumLine.get(j - 1)));
            }

            sum.get(i).add(line.get(line.size() - 1) + prevSumLine.get(prevSumLine.size() - 1));
            prevSumLine = sum.get(i);
        }

        int min = Integer.MAX_VALUE;

        for (int val: sum.get(sum.size() - 1)) min = Math.min(min, val);
        return min;
    }

}
