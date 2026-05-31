package LeetCode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 22:13
 * @desc:随机链表的复制（哈希表的使用）
 */
public class Problem138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldMapNew = new HashMap<>();
        Node cur = head;

        // 第一次遍历：创建所有新节点，存入哈希表
        while (cur != null) {
            Node newNode = new Node(cur.val);
            oldMapNew.put(cur, newNode);
            cur = cur.next;
        }

        // 第二次遍历：设置 next 和 random 指针
        cur = head;
        while (cur != null) {
            Node newNode = oldMapNew.get(cur);
            // 处理 next 指针
            newNode.next = oldMapNew.get(cur.next);
            // 处理 random 指针
            newNode.random = oldMapNew.get(cur.random);
            cur = cur.next;
        }

        // 返回新链表的头节点
        return oldMapNew.get(head);
    }
}
