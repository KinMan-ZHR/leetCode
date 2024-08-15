package list;

public class Utils {
    /**
     * 链表构造器
     */
    public static <T> ListNode<T> buildList(T[] nums)
    {
        ListNode<T>  head = new ListNode<>();
        ListNode<T>  cur = head;
        for (T num : nums)
        {
            cur.next = new ListNode<>(num);
            cur = cur.next;
        }
        return head.next;
    }
    /**
     * 链表打印器
     */
    public static <T> void printList(ListNode<T>  head)
    {
        ListNode<T>  cur = head;
        while (cur != null)
        {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    /**
     * 链表转数组
     */
    public static <T> T[] listToArray(ListNode<T> head)
    {
        ListNode<T>  cur = head;
        int  len = 0;
        while (cur != null)
        {
            len++;
            cur = cur.next;
        }
        T[]  nums = (T[]) new Object[len];
        cur = head;
        for (int i = 0; i < len; i++)
        {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return nums;
    }
    /**
     * 链表拼接
     * 把head2拼接到head1后面
     */
    public static <T> ListNode<T> append(ListNode<T> head1, ListNode<T> head2)
    {
        ListNode<T>  cur = head1;
        while (cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = head2;
        return head1;
    }


}
