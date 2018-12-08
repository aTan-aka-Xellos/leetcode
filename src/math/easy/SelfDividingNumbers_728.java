package math.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers_728 {

    public static void main(String[] args) {

        List<Integer> actual   = selfDividingNumbers(1, 22);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);

        test(expected.containsAll(actual));
    }


    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (divisible(i)) list.add(i);
        }

        return list;

    }

    private static boolean divisible(int num) {
        int copy = num;
        while (copy > 0) {
            if ((copy % 10 == 0) || num % (copy % 10) != 0) return false;
            copy /= 10;
        }
        return true;
    }

    private static void test(boolean value) {
        if (!value) throw new RuntimeException("Test failed!");
    }
}
