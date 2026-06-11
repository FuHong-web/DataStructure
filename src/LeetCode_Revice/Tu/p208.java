package LeetCode_Revice.Tu;

import LeetCode.Problem208;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/11 23:10
 * @desc:实现前缀树
 */
public class p208 {
    class Trie {
        private class TrieNode {
            Trie.TrieNode[] children;
            boolean isEnd;
            public TrieNode() {
                children = new Trie.TrieNode[26];
                isEnd = false;
            }
        }

        private Trie.TrieNode root;

        public Trie() {
            root = new Trie.TrieNode();
        }

        public void insert(String word) {
            Trie.TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie.TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            Trie.TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie.TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
            return true;
        }
    }
}
