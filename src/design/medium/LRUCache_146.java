package design.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache_146 {

    // 12/06/2020
    static class LRUCache {

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head = new Node(-1, -1);
        private final Node tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity, 1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;

            Node node = cache.get(key);
            removeNode(node);
            add(node);
            return node.val;
        }


        void removeNode(Node node) {
            cache.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next      = node;

            cache.put(node.key, node);
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                removeNode(cache.get(key));
            } else if (cache.size() == capacity) {
                removeNode(tail.prev);
            }
            add(new Node(key, val));
        }

        class Node {

            Node(int key, int val) {
                this.key  = key;
                this.val  = val;
            }

            Node prev;
            Node next;
            int key;
            int val;
        }
    }
}
