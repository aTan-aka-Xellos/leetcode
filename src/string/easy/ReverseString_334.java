package string.easy;

public class ReverseString_334 {

    public String reverseString(String s) {
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length / 2; i++) {
            char c = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = c;
        }
        return new String(a);
    }

    /**
     * Updated signature of the method.
     */
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char buffer;

        while (start < end) {
            buffer = s[start];
            s[start] = s[end];
            s[end] = buffer;
            start++;
            end--;
        }
    }
}
