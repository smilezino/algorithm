package leetcode;

/**
 * No.2
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路: 链表顺序即为数字低位到高位, 相加进位即可
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode current = null, head = null;
        while(l1 != null || l2 != null) {
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            int value = carry + x1 + x2;

            ListNode node = new ListNode(value % 10);
            if(head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
            carry = value / 10;
        }
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(4);


        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(6);

        ListNode node = addTwoNumbers(first, second);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
