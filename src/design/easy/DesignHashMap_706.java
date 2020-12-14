package design.easy;

/**
 * https://leetcode.com/problems/design-hashmap/
 */
public class DesignHashMap_706 {

    // 12/14/2020
    // Issues:
    // - confused indexes
    // - overcomplicated implementation and unnecessary corner case handling
    static class MyHashMap {

        Node root = new Node();

        public void put(int key, int value) {
            Node node = root;

            while (key > 0) {
                if (node.$[key % 10] == null) node.$[key % 10] = new Node();

                node = node.$[key % 10];
                key /= 10;
            }
            node.val = value;
        }


        public int get(int key) {
            Node node = root;
            while (node != null && key > 0) {
                node = node.$[key % 10];
                key /= 10;
            }
            return node == null ? -1 : node.val;
        }

        public void remove(int key) {
            Node node = root;
            while (node != null && key > 0) {
                node = node.$[key % 10];
                key /= 10;
            }
            if (node != null) node.val = -1;
        }


        static class Node {
            Node[] $ = new Node[10];
            int val = -1;
        }

    }
}
