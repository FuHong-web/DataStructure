package LeetCode_Revice2.Lianbiao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/17 11:12
 * @desc:LRU缓存
 */
public class p146 {
    class LRUCache {
        // 双向链表节点
        static class Node {
            int key, val;
            Node pre, next;
            Node(int k, int v) {
                key = k;
                val = v;
            }
        }

        private final int cap;
        private final Map<Integer, Node> uMap;
        private final Node head, tail;

        public LRUCache(int capacity) {
            cap = capacity;
            uMap = new HashMap<>();
            // 虚拟头尾哨兵
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (uMap.containsKey(key)) {
                Node tmp = uMap.get(key);
                remove(tmp);
                headInsert(tmp);
                return tmp.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // key已存在，先清理旧节点
            if (uMap.containsKey(key)) {
                Node old = uMap.get(key);
                remove(old);
                uMap.remove(key);
            }
            // 新建节点插入头部
            Node tmp = new Node(key, value);
            headInsert(tmp);
            uMap.put(key, tmp);

            // 超出容量，删除尾部最久未使用节点
            if (uMap.size() > cap) {
                Node toDel = tail.pre;
                remove(toDel);
                uMap.remove(toDel.key);
            }
        }

        // 对应C++ remove：仅断开链表指针
        private void remove(Node tmp) {
            Node preNode = tmp.pre;
            Node nextNode = tmp.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }

        // 对应C++ headinsert：插入head之后
        private void headInsert(Node tmp) {
            Node nxt = head.next;
            head.next = tmp;
            tmp.pre = head;
            tmp.next = nxt;
            nxt.pre = tmp;
        }
    }
}
