package tree.hard;

import java.util.LinkedList;
import java.util.Queue;

public class StreamOfCharacters_1032 {

    public static void main(String[] args) {

        String[] words = {"ab","ba","aaab","abab","baa"};

        StreamOfCharacters_1032 s = new StreamOfCharacters_1032(words);

        System.out.println(s.query('b'));
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));

    }


    Node root = new Node();
    Queue<Node> cache = new LinkedList<>();

    public StreamOfCharacters_1032(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        boolean result = false;

        cache.add(root);
        int size = cache.size();
        while (size-- > 0) {
            Node node = cache.poll().getChild(letter);
            if (node != null) {
                if (node.isWord) result = true;
                cache.add(node);
            }
        }

        return result;
    }



    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.addChildIfNull(c);
        }
        current.isWord = true;
    }

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
}
