import java.util.Arrays;

public class PalindromeNumber_9 {

    public static void main(String[] args) {

        test(isPalindrome(121), true);
        test(isPalindrome(112211), true);
        test(isPalindrome(0), true);
        test(isPalindrome(-11), false);
        test(isPalindrome(-121), false);
        test(isPalindrome(123), false);
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if ((x < 0) || (x % 10 == 0)) return false;

        int[] arr = new int[10];

        int i = 0;
        while (x > 0) {

            arr[i] = x % 10;
            x /= 10;
            i++;
        }

        arr = Arrays.copyOfRange(arr, 0, i);

        for (int j = 0; j < (arr.length / 2); j++) {

            if (arr[j] != arr[arr.length - 1 - j]) return false;

        }

        return true;
    }


    private static void test(boolean actual, boolean expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
