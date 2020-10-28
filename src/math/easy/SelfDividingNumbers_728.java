package math.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {

    // 10/28/2020
    // current % 10 => digit
    public List<Integer> selfDividingNumbers_v2(int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            int current = left;
            while (current % 10 != 0 && left % (current % 10) == 0) current /= 10;
            if (current == 0) list.add(left);
            left++;
        }
        return list;
    }


    // 12/05/2018 (slightly formatted in 2020)
    public List<Integer> selfDividingNumbers_v1(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (divisible(i)) list.add(i);
        }
        return list;
    }

    private boolean divisible(int num) {
        int copy = num;
        while (copy > 0) {
            if ((copy % 10 == 0) || num % (copy % 10) != 0) return false;
            copy /= 10;
        }
        return true;
    }

}
