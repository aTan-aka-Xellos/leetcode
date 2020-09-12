package arrays.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class DiagonalTraverse_II_1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Integer> res = new ArrayList<>();

        Map<Integer, Stack<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.getOrDefault(i + j, new Stack<>()).push(nums.get(i).get(j));
            }
        }

        for (Stack<Integer> stack : map.values()) {
            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
