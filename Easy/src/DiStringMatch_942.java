import java.util.Arrays;

public class DiStringMatch_942 {

    public static void main(String[] args) {

        assertEquals(diStringMatch("IDID"), new int[]{0,4,1,3,2});
        assertEquals(diStringMatch("III"),  new int[]{0,1,2,3});
        assertEquals(diStringMatch("DDI"),  new int[]{3,2,0,1});
    }

    public static int[] diStringMatch(String s) {

        int[] a  = new int[s.length() + 1];
        int i = 0, d = s.length();

        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'D') a[k] = d--;
            else                    a[k] = i++;
        }
        a[s.length()] = i;

        return a;
    }

    private static void assertEquals(int[] actual, int expected[]) {
        if (!Arrays.equals(actual, expected))
            System.err.println(Arrays.toString(actual) + "\n" + Arrays.toString(expected));
    }
}
