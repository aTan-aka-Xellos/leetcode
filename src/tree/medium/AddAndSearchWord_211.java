package tree.medium;

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
        return search(word, root);
    }

    /**
     * The condition with (ch == dot) always return boolean, that's why 'else' is not used.
     */
    private boolean search(String part, Node current) {
        for (int i = 0; i < part.length() && current != null; i++) {
            if (part.charAt(i) == dot) {
                for (Node child : current.children) {
                    if (search(part.substring(i + 1), child)) return true;
                }
                return false;
            }
            current = current.getChild(part.charAt(i));
        }

        return current != null && current.isWord;
    }

}
