package greedy.easy;

import java.util.Arrays;

public class AssignCookies_455 {

    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int count = 0;
        int cookie = cookies.length - 1;
        for (int i = children.length - 1; i >= 0 && cookie >= 0; i--) {
            if (children[i] <= cookies[cookie]) {
                cookie--;
                count++;
            }
        }
        return count;
    }
}
