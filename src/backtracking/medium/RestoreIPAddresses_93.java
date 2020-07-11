package backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses_93 {

    public static void main(String[] args) {
        RestoreIPAddresses_93 s = new RestoreIPAddresses_93();

        System.out.println(s.restoreIpAddresses("1111").size());

        System.out.println(s.restoreIpAddresses("255255232132").size());
        System.out.println(s.restoreIpAddresses("125523213").size());
    }


    public List<String> restoreIpAddresses(String rawIpString) {
        List<String> list = new ArrayList<>();

        exploreParts(rawIpString, 0, new StringBuilder(), list);
        return list;
    }

    void exploreParts(String ip, int currentIndex, StringBuilder builder, List<String> list) {

        int countDot = builder.toString().split("\\.").length;

        if (currentIndex == ip.length() && countDot == 4) {
            list.add(builder.toString().substring(0, builder.length() - 1)); // delete last dot
            return;
        }

        if (countDot == 4 && currentIndex < ip.length()) {
            return;
        }

        for (int i = 1; i < 4 && currentIndex + i <= ip.length(); i++) {
            String subString = ip.substring(currentIndex, currentIndex + i);

            if (isValid(subString)) {
                builder.append(subString).append(".");
                exploreParts(ip, currentIndex + subString.length(), builder, list);

                builder.deleteCharAt(builder.length() - 1); // delete dot
                builder.delete(builder.length() - subString.length(), builder.length());
            }
        }
    }

    boolean isValid(String s) {
        return (s.length() <= 1 || !s.startsWith("0")) && Integer.parseInt(s) <= 255;
    }

}
