package list;

public class ListNode <T>{
    // 结点的值
    T val;

    // 下一个结点
    ListNode<T> next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(T val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

}