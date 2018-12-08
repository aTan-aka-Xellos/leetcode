package math.easy;

public class BinaryGap_868 {

    public static void main(String[] args) {

        assertEquals(binaryGap(5), 2);
        assertEquals(binaryGap(6), 1);
        assertEquals(binaryGap(8), 0);
        assertEquals(binaryGap(22), 2);
    }

    public static int binaryGap(int N) {

        char[] bits = Integer.toBinaryString(N).toCharArray();
        int max = 0, counter = 0;

        for (int i = 1; i < bits.length; i++) {
            if (bits[i] == '0') counter++;
            else {
                max = Math.max(max, ++counter);
                counter = 0;
            }
        }
        return max;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
