package bs.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore_981 {


    private final Map<String, List<Integer>> timestamps = new HashMap<>(); // { key: [timestamps] }
    private final Map<Integer, String> values = new HashMap<>();           // { timestamp: value }

    public void set(String key, String value, int timestamp) {
        values.put(timestamp, value);
        timestamps.putIfAbsent(key, new ArrayList<>());
        timestamps.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {
        Integer minTimestamp = bs(timestamps.get(key), timestamp);
        return minTimestamp != -1 ? values.get(minTimestamp) : "";
    }

    private Integer bs(List<Integer> times, Integer timestamp) {
        if (times == null || times.isEmpty() || times.get(0) > timestamp) return -1;

        int L = 0, R = times.size();

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (times.get(mid) > timestamp) R = mid;
            else                            L = mid;
        }
        return times.get(L);
    }

}
