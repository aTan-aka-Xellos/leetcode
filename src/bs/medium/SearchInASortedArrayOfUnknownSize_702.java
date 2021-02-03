package bs.medium;

/**
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class SearchInASortedArrayOfUnknownSize_702 {

    public int search(ArrayReader reader, int target) {
        int L = 0, R = 1;

        while (reader.get(R) != Integer.MAX_VALUE) R <<= 1;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (reader.get(mid) > target) R = mid;
            else L = mid;
        }
        return reader.get(L) == target ? L : -1;
    }


    interface ArrayReader {
        int get(int index);
    }
}
