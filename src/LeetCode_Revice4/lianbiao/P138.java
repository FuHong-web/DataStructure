package LeetCode_Revice4.lianbiao;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.HashMap;
import java.util.Map;

/*随机链表的复制*/
public class P138 {
    public Node copyRandomList(Node head) {
        Map<Node,Node> oldMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            oldMap.put(cur,newNode);
            cur = cur.next;
        }

        cur = head;
        while (cur!=null){
            Node newNode = oldMap.get(cur);
            newNode.next = oldMap.get(cur.next);
            newNode.random = oldMap.get(cur.random);
            cur = cur.next;
        }
        return oldMap.get(head);
    }
}
