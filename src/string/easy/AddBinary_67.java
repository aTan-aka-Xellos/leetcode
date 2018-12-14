package string.easy;

import static java.lang.Character.getNumericValue;

public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }


    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, rem = 0, sum;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || rem == 1) {
            sum = rem;

            if (i >= 0) sum += getNumericValue(a.charAt(i--));
            if (j >= 0) sum += getNumericValue(b.charAt(j--));

            rem  = sum / 2;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }

}
