package graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule_207 {

    // 03/03/2021
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];

        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] req: prerequisites) {
            prereq.computeIfAbsent(req[0], k -> new ArrayList<>()).add(req[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(prereq, state, i)) return false;
        }
        return true;
    }

    /**
     * state = 1  -> checked and valid
     * state = -1 -> already visited, loop detected
     * state = 0  -> not checked or visited
     */
    private boolean canFinish(Map<Integer, List<Integer>> prereq, int[] state, int course) {
        if (state[course] < 0) return false; // already visited, loop detected
        if (state[course] > 0) return true;  // already checked, can be finished

        state[course] = -1; // mark visited
        for (int req: prereq.getOrDefault(course, new ArrayList<>())) {
            if (!canFinish(prereq, state, req)) return false;
        }
        state[course] = -state[course]; // mark finished
        return true;
    }
}
