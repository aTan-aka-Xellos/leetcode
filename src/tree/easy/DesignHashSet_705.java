package tree.easy;

/**
 * https://leetcode.com/problems/design-hashset
 */
public class DesignHashSet_705 {


    Node root = new Node();

    public void add(int key) {
        Node current = root;

        do {
            int rem = key % 10;
            key /= 10;
            if (current.digits[rem] == null) current.digits[rem] = new Node();
            current = current.digits[rem];
        } while (key > 0);
        current.isNumber = true;
    }

    public void remove(int key) {
        Node current = root;
        do {
            current = current.digits[key % 10];
            key /= 10;
            if (current == null) return;
        } while (key > 0);
        current.isNumber = false;
    }


    public boolean contains(int key) {
        Node current = root;
        do {
            current = current.digits[key % 10];
            key /= 10;
        } while (current != null && key > 0);
        return current != null && current.isNumber;
    }


    static class Node {
        Node[] digits = new Node[10];
        boolean isNumber = false;
    }



}
