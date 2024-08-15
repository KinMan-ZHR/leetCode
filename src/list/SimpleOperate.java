package list;

public class SimpleOperate {
    /**
     * 移除链表元素
     */
    public static <T> ListNode<T> removeElements(ListNode<T> head, T val) {
        while (head != null && head.val == val) {//对于头结点要移除元素
            head = head.next;
        }
        if (head == null) {
            return null;//没活了，整个链表全是目标值
        }
        ListNode<T> pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
    /**
     * 删除链表的倒数第N个节点
     */
    public static <T> ListNode<T> removeNthFromEnd(ListNode<T> head, int n) {
        ListNode<T> dummy = new ListNode<>(null, head);
        ListNode<T> first = head;
        ListNode<T> second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
       }
        second.next = second.next.next;
        return dummy.next;
    }
    /**
     * 插入链表节点
     */
    public static <T> ListNode<T> insert(ListNode<T> head, T val, int index) {
        ListNode<T> dummy = new ListNode<>(null, head);
        ListNode<T> cur = dummy;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        ListNode<T> newNode = new ListNode<>(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return dummy.next;
    }
    /**
     * 获取链表节点
     */
    public static <T> ListNode<T> get(ListNode<T> head, int index) {
        ListNode<T> cur = head;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur;
    }
    /**
     * 翻转链表
     */
    public static <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        while (cur != null) {
            ListNode<T> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    /**
     * swapPairs
     */
    public static <T> ListNode<T> swapPairs(ListNode<T> head) {
        ListNode<T> dummy = new ListNode<>(null, head);
        ListNode<T> cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode<T> first = cur.next;
            ListNode<T> second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
    /**
     * mySwapPairs
     */
    public static <T> ListNode<T> mySwapPairs(ListNode<T> head) {
        ListNode<T> dummy = new ListNode<>(null, head);
        ListNode<T> cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode<T> first = cur.next;
            ListNode<T> second = cur.next.next;
            first.next = second.next;//1指向3
            cur.next = second;//头指向2
            second.next = first;//2指向1
            cur = first;//头移动两步来到1
        }
        return dummy.next;
    }
    /**
     * 链表相交
     */
    public static <T> ListNode<T> getIntersectionNode(ListNode<T> headA, ListNode<T> headB) {
        ListNode<T> p = headA;
        ListNode<T> q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;//如果p为空，则p指向headB,否则指向p的下一个节点
            q = q == null ? headA : q.next;//如果q为空，则q指向headA,否则指向q的下一个节点
        }
        return p;
    }
    /**
     * 链表是否循环，在圈圈里一定可以追上，当fast的速度为2倍slow的速度时，一定在slow进入圈内的第一圈就相遇
     */
    public static <T> ListNode<T> hasCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode<T> p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;

            }
        }
        return null;
    }




}
