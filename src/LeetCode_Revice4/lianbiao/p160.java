package LeetCode_Revice4.lianbiao;
/*
* - A 链表长度：`a + c`（a 是 A 独有的部分，c 是相交公共部分）
- B 链表长度：`b + c`（b 是 B 独有的部分，c 是相交公共部分）

指针 a：先走 A 全部 `a+c`，走到 null，跳到 B 头，再走`b`
指针 b：先走 B 全部 `b+c`，走到 null，跳到 A 头，再走`a`

总路程：

- a 走：`a + c + b`
- b 走：`b + c + a`

👉 **两者走过总路程相等，一定会在交点相遇。**

### 两种情况

1. **有交点**：a、b 会同时走到相交节点，`a==b`，返回该节点。
2. **没有交点**：两个指针都会走到 null，`a==b(null)`，返回 null。
* */
import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*相交链表*/
public class p160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b) {
            a = (a== null) ? b : a.next;
            b = (b== null) ? a : b.next;
        }
        return a;
    }
}
