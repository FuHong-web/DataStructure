package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/8 22:47
 * @desc:实现前缀树
 */
public class Problem208 {
    class Trie {
        private class TrieNode {
            TrieNode[] children;
            boolean isEnd;
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
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
            TrieNode cur = root;
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
