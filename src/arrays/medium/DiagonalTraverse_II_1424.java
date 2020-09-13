package arrays.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class DiagonalTraverse_II_1424 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(){{add(1); add(2);}});
        list.add(new ArrayList<Integer>(){{add(3); add(4);}});

        findDiagonalOrder_Dijkstra(list);
    }

    public static int[] findDiagonalOrder_Dijkstra(List<List<Integer>> nums) {

        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(Comparator.<Integer[]>comparingInt(a -> a[0] + a[1]).thenComparingInt(a -> a[1]));

        queue.add(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (nums.get(row).get(col) == Integer.MIN_VALUE) continue;

            res.add(nums.get(row).get(col));
            nums.get(row).set(col, Integer.MIN_VALUE);

            if (row + 1 < nums.size() && col < nums.get(row + 1).size())
                queue.add(new Integer[]{row + 1, col});

            if (row < nums.size()     && col + 1 < nums.get(row).size())
                queue.add(new Integer[]{row, col + 1});
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

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
