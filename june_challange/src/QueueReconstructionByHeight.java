import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {


        // {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}


        // 7-0  7-1  6-1  5-0  5-2  4-4
        // 5-0	7-0  5-2  6-1  4-4  7-1

        // 7-0
        // 7-0 7-1
        // 7-0 6-1 7-1
        // 5-0 7-0 6-1 7-1
        // 5-0 7-0 5-2 6-1 7-1
        // 5-0 7-0 5-2 6-1 4-4 7-1


        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {

        int[][] people = {{7,0}, {4,4}, {7,1}, {5,2}, {6,1}, {5,0}};
        reconstructQueue(people);
    }

}
