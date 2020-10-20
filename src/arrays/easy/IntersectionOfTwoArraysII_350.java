package arrays.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII_350 {


    public int[] intersect_v1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] intersect_v2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <  nums2[j]) i++;
            else if (nums1[i] >  nums2[j]) j++;
            else {
                list.add(nums1[i]);
                i++; j++;
            }
        }

        return list.stream().mapToInt(x->x).toArray();
    }
}
