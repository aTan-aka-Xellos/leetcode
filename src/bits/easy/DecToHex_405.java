package bits.easy;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class DecToHex_405 {

    private static String[] dictionary = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String toHex(int num) {
        if (num == 0) return "0";
        String hex = "";

        while (num != 0) {
            hex = dictionary[num & 0xf] + hex;
            num >>>= 4;
        }
        return hex;
    }

    public static void main(String[] args) {
        System.out.println(toHex(0).equals("0"));
        System.out.println(toHex(1).equals("1"));
        System.out.println(toHex(-1).equals("ffffffff"));
        System.out.println(toHex(26).equals("1a"));

        System.out.println(toHex(Integer.MAX_VALUE).equals("7fffffff"));
        System.out.println(toHex(Integer.MIN_VALUE).equals("80000000"));
    }
}
