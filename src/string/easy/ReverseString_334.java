package string.easy;

public class ReverseString_334 {

    public static String reverseString(String s) {
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length / 2; i++) {
            char c = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = c;
        }
        return new String(a);
    }
}
