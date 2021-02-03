package bs.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */
public class SortIntegersByThePowerValue_1387 {



    static int[] cache = new int[1000 * 500];

    // 01/31/2021
    public int getKth(int lo, int hi, int k) {
        int[][] arr = new int[hi - lo + 1][2];

        for (int i = lo; i <= hi; i++) {
            arr[i - lo][0] = i;
            arr[i - lo][1] = getPower(i);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        return arr[k - 1][0];
    }


    int getPower(int n) {
        int count = 0, orig = n;

        while (n != 1) {
            if (cache[n] > 0) return count + cache[n];

            if (n % 2 == 0) n >>= 1;
            else            n = (3 * n + 1);
            count++;
        }

        cache[orig] = count;
        return count;
    }

}
