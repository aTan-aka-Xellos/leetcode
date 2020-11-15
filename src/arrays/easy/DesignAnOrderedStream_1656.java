package arrays.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-an-ordered-stream/
 *
 * Weekly context 215
 */
public class DesignAnOrderedStream_1656 {

    static class OrderedStream {

        int ptr = 1;
        String[] data;

        public OrderedStream(int n) {
            data = new String[n + 1];
        }

        public List<String> insert(int id, String value) {
            List<String> list = new ArrayList<>();
            data[id] = value;

            while (ptr < data.length && data[ptr] != null) {
                list.add(data[ptr]);
                ptr++;
            }
            return list;
        }
    }


}
