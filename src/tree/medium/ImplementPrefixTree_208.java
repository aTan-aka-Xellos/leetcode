package tree.medium;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementPrefixTree_208 {

    static class Node {

        // could be stored as a marker in the array of children
        boolean isWord = false;
        Node[] children;

        Node() {
            children = new Node[26];
        }

        Node getChild(char c) {
            int index = c - 'a';
            return children[index];
        }

        Node addChildIfNull(char c) {
            int index = c - 'a';
            Node node = children[index];

            if (node == null) {
                children[index] = new Node();
            }
            return children[index];
        }
    }


    Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            current = current.addChildIfNull(c);
        }
        current.isWord = true;
    }


    public boolean search(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            current = current.getChild(c);
            if (current == null) return false;
        }
        return current.isWord;
    }


    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c: prefix.toCharArray()) {
            current = current.getChild(c);
            if (current == null) return false;
        }
        return true;
    }


    // could be used to reduce code duplication
    private Node find(String key) {
        Node current = root;
        for (int i = 0; i < key.length() && current != null; i++) {
            current = current.getChild(key.charAt(i));
        }
        return current;
    }

}
