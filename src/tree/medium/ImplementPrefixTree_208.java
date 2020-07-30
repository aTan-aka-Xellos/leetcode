package tree.medium;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementPrefixTree_208 {

    static class Node {

        boolean isWord = false;
        Node[] children;

        Node() {
            children = new Node[26];
        }

        Node getChild(char ch) {
            return children[ch - 'a'];
        }

        Node addChildIfNull(char ch) {
            int index = ch - 'a';

            if (children[index] == null) {
                children[index] = new Node();
            }
            return children[index];
        }
    }


    Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.addChildIfNull(c);
        }
        current.isWord = true;
    }


    public boolean search(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.getChild(c);
            if (current == null) return false;
        }
        return current.isWord;
    }


    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
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
