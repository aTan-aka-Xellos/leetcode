package arrays.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray_88 {

    // 12/13/2020
    // had issues because tried to use only 2 if statements, without first 2 <= over-optimization
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        m--;
        n--;

        while (idx >= 0) {
                 if (n < 0) nums1[idx] = nums1[m--];
            else if (m < 0) nums1[idx] = nums2[n--];
            else if (nums1[m] > nums2[n]) nums1[idx] = nums1[m--];
            else                          nums1[idx] = nums2[n--];

            idx--;
        }
    }

}
