package com.lsy.learn.projectlsy.algorithm;


import java.util.HashMap;

class Trie {

    class Node {
        private boolean word;
        private HashMap<Character, Node> node;

        public Node(boolean word) {
            this.word = word;
            this.node = new HashMap<>();
        }
    }

    private Node root;


    public Trie() {
        root = new Node(false);
    }

    public void insert(String word) {
        Node cur = this.root;
        for (int index = 0; index < word.length(); index++) {
            char c = word.charAt(index);
            if (cur.node.get(c) == null) {
                boolean word_t = false;
                if (index == word.length() - 1) {
                    word_t = true;
                }
                cur.node.put(c, new Node(word_t));
            }
            cur = cur.node.get(c);
        }
    }

    public boolean search(String word) {
        Node cur = this.root;
        for (int index = 0; index < word.length(); index++) {
            char c = word.charAt(index);
            if (cur.node.get(c) == null) {
                return false;
            }
            cur = cur.node.get(c);
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        Node cur = this.root;
        for (int index = 0; index < prefix.length(); index++) {
            char c = prefix.charAt(index);
            if (cur.node.get(c) == null) {
                return false;
            }
            cur = cur.node.get(c);
        }
        return true;
    }
}

public class LC_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("app");
//        System.out.println(trie.startsWith("ap"));
//        System.out.println(trie.search("ap"));
//        System.out.println(trie.search("app"));
//
//        trie.insert("yanhui");
//        System.out.println(trie.startsWith("ya"));
//        System.out.println(trie.startsWith("yanhu"));
//        System.out.println(trie.search("yanhu"));
//        System.out.println(trie.search("yanhui"));

        trie.insert("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(trie.startsWith("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(trie.startsWith("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(trie.search("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(trie.search("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaawwww"));
        System.out.println(trie.search("zakdasdadsadasdsadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));


    }


}
