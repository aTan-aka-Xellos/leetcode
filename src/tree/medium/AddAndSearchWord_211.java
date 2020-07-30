package tree.medium;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design
 */
public class AddAndSearchWord_211 {

    static class Node {

        boolean isWord = false;
        Node[] children = new Node[26];

        Node addNodeIfNull(char ch) {
            int index = ch - 'a';
            return  children[index] == null ?
                    children[index] = new Node() :
                    children[index];
        }

        Node getChild(char ch) {
            return children[ch - 'a'];
        }
    }


    int dot = '.';
    Node root = new Node();

    public void addWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            current = current.addNodeIfNull(ch);
        }
        current.isWord = true;
    }


    public boolean search(String word) {
        return search(word, 0, root);
    }

    /**
     * The condition with (ch == dot) always return boolean, that's why 'else' is not used.
     */
    private boolean search(String word, int beginIndex, Node current) {
        for (int i = beginIndex; i < word.length() && current != null; i++) {
            if (word.charAt(i) == dot) {
                for (Node child : current.children) {
                    if (search(word, i + 1, child)) return true;
                }
                return false;
            }
            current = current.getChild(word.charAt(i));
        }

        return current != null && current.isWord;
    }

}
