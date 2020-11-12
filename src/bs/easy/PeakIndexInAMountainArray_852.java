package bs.easy;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInAMountainArray_852 {

    // 11/12/2020
    public int peakIndexInMountainArray(int[] arr) {
        int mid = 0, l = 0, r = arr.length;

        while (r - l > 1) {
            mid = (r + l) >>> 1;
            if (arr[mid] > arr[mid - 1]) l = mid;
            else if (arr[mid] < arr[mid - 1]) r = mid;
        }
        return l;
    }


}
