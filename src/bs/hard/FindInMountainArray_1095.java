package bs.hard;

/**
 * https://leetcode.com/problems/find-in-mountain-array/
 */
public class FindInMountainArray_1095 {

    public int findInMountainArray(int target, MountainArray mArr) {
        int L = 0, R = mArr.length();

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (mArr.get(mid) > mArr.get(mid - 1)) L = mid;
            else                                   R = mid;
        }
        if (mArr.get(L) == target) return L;
        int peak = L;

        L = 0; R = peak;
        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (mArr.get(mid) <= target) L = mid;
            else                         R = mid;
        }
        if (mArr.get(L) == target) return L;

        L = peak; R = mArr.length();
        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (mArr.get(mid) >= target) L = mid;
            else                         R = mid;
        }
        if (mArr.get(L) == target) return L;
        return -1;
    }

    interface MountainArray {
        int get(int index);
        int length();
    }


}
