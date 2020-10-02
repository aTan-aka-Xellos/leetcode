package arrays.easy;

import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 */
public class MaximumDistanceInArrays_624 {

    public int maxDistance(List<List<Integer>> arrays) {

        int distance = 0, min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {

            int A = Math.max(distance, arrays.get(i).get(arrays.get(i).size() - 1) - min);
            int B = Math.max(distance, max - arrays.get(i).get(0));

            distance = Math.max(distance, Math.max(A,B));

            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return distance;
    }


}
