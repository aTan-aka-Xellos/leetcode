package string.easy;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings_415 {


    // 12/09/2020
    // totally confused operations, limits, corner cases
    // missed usage of StringBuilder
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int l1 = n1.length - 1, l2 = n2.length - 1, sum = 0;

        while (l1 >= 0 || l2 >= 0 || sum > 0) {
            sum += l1 < 0 ? 0 : Character.digit(n1[l1--], 10);
            sum += l2 < 0 ? 0 : Character.digit(n2[l2--], 10);

            sb.append(sum % 10);
            sum /= 10;
        }
        return sb.reverse().toString();
    }
}
