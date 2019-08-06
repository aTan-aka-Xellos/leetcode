package string.easy;

public class ReverseString_334 {

    /**
     * https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1440/
     */
    public void reverseString_recursive(char[] s) {
        move(0, s);
    }

    private void move(int index, char[] s) {
        if (s == null || index >= s.length / 2) return;

        move(index + 1, s);

        char temp = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = temp;
    }


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
