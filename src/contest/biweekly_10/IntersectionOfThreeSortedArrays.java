package contest.biweekly_10;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/contest/biweekly-contest-10/problems/intersection-of-three-sorted-arrays
 */
public class IntersectionOfThreeSortedArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        int[] counts = new int[2000];

        proceed(arr1, counts);
        proceed(arr2, counts);
        proceed(arr3, counts);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 3) {
                list.add(i);
            }
        }
        return list;

    }

    private void proceed(int[] arr, int[] counts) {
        for (int value : arr) {
            counts[value]++;
        }
    }
}
