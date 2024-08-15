package list;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MethodTest {

    // 测试
    @Test
    public void TestRemoveElements() {
        Integer[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode<Integer> head = Utils.buildList(nums);
        int val = 6;
        ListNode<Integer> result = SimpleOperate.removeElements(head, val);
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 4, 5}), Arrays.toString(Utils.listToArray(result)));

    }
    @Test
    public void removeNthFromEnd() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.removeNthFromEnd(head, 2);
        Utils.printList(result);
        assertEquals(Arrays.toString(new int[]{1, 2, 3, 5}), Arrays.toString(Utils.listToArray(result)));
    }
    @Test
    public void TestInsert() {
        Integer[] nums = {1, 2, 3, 4, 5};

        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.insert(head, 6, 2);
        Utils.printList(result);
        assertEquals(Arrays.toString(new int[]{1, 2, 6, 3, 4, 5}), Arrays.toString(Utils.listToArray(result)));
    }
    @Test
    public void TestReverse() {
        Integer[] nums = {1, 2, 3, 4};
        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.reverse(head);
        Utils.printList(result);
        assertEquals(Arrays.toString(new int[]{4, 3, 2, 1}), Arrays.toString(Utils.listToArray(result)));
    }
    @Test
    public void TestGet() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.get(head, 2);
        assertEquals(3, (int)result.val);
    }
    @Test
    public void TestSwapPairs() {
        Integer[] nums = {1, 2, 3, 4,5};
        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.swapPairs(head);
        Utils.printList(result);
        assertEquals(Arrays.toString(new int[]{2, 1, 4, 3,5}), Arrays.toString(Utils.listToArray(result)));
    }
    @Test
    public void TestMySwapPairs() {
        Integer[] nums = {1, 2, 3, 4,5};
        ListNode<Integer> head = Utils.buildList(nums);
        ListNode<Integer> result = SimpleOperate.mySwapPairs(head);
        Utils.printList(result);
        assertEquals(Arrays.toString(new int[]{2, 1, 4, 3,5}), Arrays.toString(Utils.listToArray(result)));
    }
    @Test
    public void TestGetIntersectionNode() {
        Integer[] nums1 = {3,46,3,1, 2, 3, 4, 5};
        Integer[] nums2 = {23,14, 52, 5};
        Integer[] nums3 = {8,45,4,35};
        ListNode<Integer> head3 = Utils.buildList(nums3);
        ListNode<Integer> head1 = Utils.buildList(nums1);
        ListNode<Integer> head2 = Utils.buildList(nums2);
        Utils.append(head1, head3);
        Utils.append(head2, head3);
        ListNode<Integer> result = SimpleOperate.getIntersectionNode(head1, head2);

        assertEquals(head3, result);
    }
    @Test
    public void TestHasCycle() {
        Integer[] nums = {1, 2, 3, 4, 5};
        ListNode<Integer> head = Utils.buildList(nums);
        assertNull(SimpleOperate.hasCycle(head));
        Utils.append(head, head.next.next);
        assertEquals(head.next.next,SimpleOperate.hasCycle(head));
    }

   

}
