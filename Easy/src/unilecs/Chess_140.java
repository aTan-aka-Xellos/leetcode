package unilecs;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://telegra.ph/Anons-140-Loshadyu-hodi-11-12
 */
public class Chess_140 {

    private static final int[] X_AXIS = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] Y_AXIS = {2, 1, -1, -2, -2, -1, 1, 2};

    private static final Map<Character, Integer> BOARD = new HashMap<>();
    static {
        BOARD.put('A', 1);
        BOARD.put('B', 2);
        BOARD.put('C', 3);
        BOARD.put('D', 4);
        BOARD.put('E', 5);
        BOARD.put('F', 6);
        BOARD.put('G', 7);
        BOARD.put('H', 8);
    }

    public static void main(String[] args) {
        test();

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        char[] input = sc.next().toCharArray();
        validation(input);

        int x1 = BOARD.get(input[0]);
        int y1 = Character.getNumericValue(input[1]);
        int x2 = BOARD.get(input[3]);
        int y2 = Character.getNumericValue(input[4]);

        out.print(isHorse(x1, y1, x2, y2));
        out.flush();
        out.close();
        sc.close();
    }

    /**
     * Validate that char representation of input is [A-H] or [1-8]
     */
    private static void validation(char[] input) {
        if (input[0] < 65 || input[3] < 65 ||
            input[0] > 72 || input[3] > 72 ||
            input[1] < 49 || input[4] < 49 ||
            input[1] > 56 || input[4] > 56) {
            throw new IllegalArgumentException("Wrong input!");
        }
    }

    private static boolean isHorse(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < X_AXIS.length; i++) {
            if (x1 + X_AXIS[i] == x2 && y1 + Y_AXIS[i] == y2) return true;
        }
        return false;
    }

    // run with -ea
    private static void test() {

        assert !isHorse(5, 2, 5, 4);
        assert !isHorse(1, 2, 1, 1);
        assert !isHorse(3, 3, 4, 4);
        assert !isHorse(3, 3, 5, 5);
        assert !isHorse(8, 3, 8, 1);

        assert isHorse(2, 2, 3, 4);
        assert isHorse(8, 3, 7, 1);
        assert isHorse(3, 3, 5, 4);
        assert isHorse(3, 3, 4, 5);
    }
}
