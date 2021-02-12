package unionfind.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence_128 {

    // 02/11/2021
    public int longestConsecutive_v1(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);

        int max = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
                max = Math.max(max, count);
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
        }
        return max;
    }

    // 02/12/2021
    // intentionally UF solution
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int max = 1;
        UnionFind UF = new UnionFind(n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) map.put(nums[i], i);

        for (int num: nums) {
            if (map.containsKey(num - 1)) max = Math.max(max, UF.union(map.get(num), map.get(num - 1)));
            if (map.containsKey(num + 1)) max = Math.max(max, UF.union(map.get(num), map.get(num + 1)));
        }
        return max;
    }


    public static class UnionFind {

        int[] root;
        int[] size;

        public UnionFind(int N) {
            root = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        int findRoot(int node) {
            if (root[node] == node) return node;
            root[node] = findRoot(root[node]);
            return root[node];
        }

        int union(int a, int b) {
            int parentA = findRoot(a);
            int parentB = findRoot(b);
            if (!isConnected(parentA, parentB)) {
                root[parentB] = parentA;
                size[parentA] += size[parentB];
            }
            return size[parentA];
        }

        boolean isConnected(int a, int b) {
            return findRoot(a) == findRoot(b);
        }
    }
}
