package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/6 22:36
 * @desc:LRU缓存
 */
public class Problem146 {
    class LRUCache {
        // 双向链表节点
        static class Node {
            int key, value;
            Node pre, next;
            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> map;
        private final Node head, tail;

        // 构造方法 → 必须是 public！
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            // 虚拟头尾节点，避免空判断
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToHead(node);  // 访问过 → 移到头部（标记最近使用）
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 更新
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                // 新增
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);

                // 超过容量 → 删除最久未使用（尾部）
                if (map.size() > capacity) {
                    Node tailNode = removeTail();
                    map.remove(tailNode.key);
                }
            }
        }

        // 工具方法：添加节点到头部（最近使用）
        private void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        // 工具方法：删除任意节点
        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        // 工具方法：移到头部
        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        // 工具方法：删除尾部节点（最久未使用）
        private Node removeTail() {
            Node res = tail.pre;
            removeNode(res);
            return res;
        }
    }
}
