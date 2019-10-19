package contest.biweekly_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/contest/biweekly-contest-11/problems/meeting-scheduler/
 */
public class MeetingScheduler_1229 {

    public static void main(String[] args) {

        System.out.println(minAvailableDuration(new int[][]{{7,50},{60,120},{140,210}}, new int[][]{{6,14},{60,70}}, 10));
        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 8));
        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70}}, 12));

        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70},{140,210}}, 50));
        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70},{160,210}}, 50));
        System.out.println(minAvailableDuration(new int[][]{{10,50},{60,120},{140,210}}, new int[][]{{0,15},{60,70},{140,210}}, 70));


        System.out.println(minAvailableDuration(new int[][]{{10,50}}, new int[][]{{0,15}}, 5));
        System.out.println(minAvailableDuration(new int[][]{{10,50}}, new int[][]{{0,15}}, 6));
        System.out.println(minAvailableDuration(new int[][]{{10,50}}, new int[][]{{0,15}}, 1));

        // [98730764,99186849]
        System.out.println(minAvailableDuration(
            new int[][]{{216397070,363167701},{98730764,158208909},{441003187,466254040},{558239978,678368334},{683942980,717766451}},
            new int[][]{{50490609,222653186},{512711631,670791418},{730229023,802410205},{812553104,891266775},{230032010,399152578}},
            456085));
    }

    public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> list = new ArrayList<>();

        // input is unsorted
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        for (int[] slot1 : slots1) {
            int start1 = slot1[0];
            int end1   = slot1[1];

            int j = 0;
            for (; j < slots2.length; j++) {
                int start2 = slots2[j][0];
                int end2 = slots2[j][1];

                if (start1 >= start2 && (start1 + duration) <= end1 && (start1 + duration) <= end2) {
                    list.add(start1);
                    list.add(start1 + duration);
                    return list;
                } else if (start2 >= start1 && (start2 + duration) <= end2 && (start2 + duration) <= end1) {
                    list.add(start2);
                    list.add(start2 + duration);
                    return list;
                }
            }
        }
        return list;
    }
}
