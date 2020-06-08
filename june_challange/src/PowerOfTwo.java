public class PowerOfTwo {


    public boolean isPowerOfTwo(int n) {
        char[] chars = Integer.toString(n,2).toCharArray();

        int count = 0;
        for (char value: chars) {
            if (value == '1') count++;
        }
        return n > 0 && count <= 1;
    }

    public boolean isPowerOfTwo_fromDiscussions(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}
