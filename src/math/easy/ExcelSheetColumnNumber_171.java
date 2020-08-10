package math.easy;

public class ExcelSheetColumnNumber_171 {

    public int titleToNumber(String s) {
        int num = 0;
        int factor = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - 64) * factor;
            factor *= 26;
        }
        return num;
    }

}
