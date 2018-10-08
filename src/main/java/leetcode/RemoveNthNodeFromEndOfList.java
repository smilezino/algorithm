package leetcode;

/**
 * No.19
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 思路：p1 先移动 n 距离，p1 往后移动到最后，同时p2开始移动
     *      p1 ->
     * | n  |
     * 1 -> 2 -> 3 -> 4 -> 5
     * |
     * p2 ->
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        for(int i=0; i<n; i++) {
            if(p1.next == null) {
                return null;
            }
            p1 = p1.next;
        }
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();

    }

}
