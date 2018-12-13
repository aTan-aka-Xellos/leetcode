package bs.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658 {

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
