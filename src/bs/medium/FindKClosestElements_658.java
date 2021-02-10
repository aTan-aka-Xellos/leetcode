package bs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements
 */
public class FindKClosestElements_658 {

    // 02/06/2021
    // regular pattern didn't work
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int mid, lo = 0, hi = arr.length - k;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(arr[lo + i]);
        }
        return res;
    }
}
