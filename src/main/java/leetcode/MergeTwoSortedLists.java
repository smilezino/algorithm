package leetcode;

/**
 * No.21
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * 思路：两个链表都有序，遍历即可
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            node.next = l1;
        }
        if(l2 != null) {
            node.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }
}
