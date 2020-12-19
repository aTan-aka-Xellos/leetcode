package design.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-browser-history/
 */
public class DesignBrowserHistory_1472 {

    // 12/20/2020
    static class BrowserHistory {

        int index = 0, lastHistory = 0;
        String[] history = new String[32];

        public BrowserHistory(String homepage) {
            history[0] = homepage;
        }

        public void visit(String url) {
            ensureCapacity();
            history[++index] = url;
            lastHistory = index;
        }

        public String back(int steps) {
            index = Math.max(0, index - steps);
            return history[index];
        }

        public String forward(int steps) {
            index = Math.min(lastHistory, index + steps);
            return history[index];
        }

        void ensureCapacity() {
            if (history.length == index + 1) {
                history = Arrays.copyOf(history, history.length * 2);
            }
        }
    }


    // 12/20/2020
    static class BrowserHistory_v1 {

        private Node cursor;

        public BrowserHistory_v1(String homepage) {
            cursor = new Node(homepage);
        }

        public void visit(String url) {
            cursor.next = new Node(url);
            cursor.next.prev = cursor;
            cursor = cursor.next;
        }

        public String back(int steps) {
            while (steps-- > 0 && cursor.prev != null) {
                cursor = cursor.prev;
            }
            return cursor.url;
        }

        public String forward(int steps) {
            while (steps-- > 0 && cursor.next != null) {
                cursor = cursor.next;
            }
            return cursor.url;
        }

        static class Node {
            String url;
            Node prev;
            Node next;
            Node(String url) { this.url = url; }
        }
    }
}
