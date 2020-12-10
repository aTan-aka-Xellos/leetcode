package math.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle_168 {

    // 12/10/2020
    // struggled a lot, took ~20-25 min, totally missed '-1'
    public String convertToTitle(int n) {
        String res = "";

        while (n > 0 ) {
            n--;
            res = (char)(n % 26 + 'A') + res;
            n /= 26;
        }
        return res;
    }

}
