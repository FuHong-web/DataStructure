package LeetCode_Revice5.lianbiao;

import java.util.HashMap;
import java.util.Map;

/*随机链表的复制*/
public class p138 {
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        // key：原链表节点，value：对应的新拷贝节点
        Map<Node,Node> oldMap = new HashMap<>();
        Node cur = head;
        // 第一轮遍历：只创建新节点，存入map，只拷贝val，不处理next和random
        while (cur != null) {
            Node newNode = new Node(cur.val);
            oldMap.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        // 第二轮遍历：给新节点挂 next 和 random
        while (cur!=null){
            Node newNode = oldMap.get(cur);
            // 新节点的next = 原节点next对应的拷贝节点
            newNode.next = oldMap.get(cur.next);
            // 新节点的random = 原节点random对应的拷贝节点
            newNode.random = oldMap.get(cur.random);
            cur = cur.next;
        }
        // 返回原head对应的拷贝节点，就是新链表头
        return oldMap.get(head);
    }

}
