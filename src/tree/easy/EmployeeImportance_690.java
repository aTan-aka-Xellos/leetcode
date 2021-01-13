package tree.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance_690 {

    // 01/13/2021
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) map.put(e.id, e);

        Queue<Employee> q = new LinkedList<>();
        q.offer(map.get(id));

        while (!q.isEmpty()) {
            Employee e = q.poll();
            sum += e.importance;
            for (Integer _id: e.subordinates) q.offer(map.get(_id));
        }
        return sum;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
