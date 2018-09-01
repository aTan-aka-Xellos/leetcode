import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombOfPhoneNumber_17 {


    private static Map<Character, String[]> map = new HashMap<>();
    static {
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});
    }

    public static void main(String[] args) {
        List<String> list = combine("234");
        list.forEach(System.out::println);
    }

    private static List<String> combine(String digits) {

        if (digits.isEmpty()) return Collections.emptyList();

        char[] arr = digits.toCharArray();

        int combinations = 1;
        for (char anArr : arr) {
            combinations *= map.get(anArr).length;
        }

        String[] result = new String[combinations];

        int koef = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 0;

            do {
                for (String letter : map.get(arr[i])) {
                    for (int k = 0; k < koef; k++) {
                        result[count] = letter + (result[count] == null ? "" : result[count]);
                        count++;
                    }
                }
            } while(count < combinations);
            koef *= map.get(arr[i]).length;
        }
        return Arrays.asList(result);
    }

}
