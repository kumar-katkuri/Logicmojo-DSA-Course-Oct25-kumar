/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *
 *     Navie approach this works for ceratin test cases only.
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int firstNodeSum = 0;
        while (l1 != null) {
            firstNodeSum = (firstNodeSum * 10) + l1.val;
            l1 = l1.next;
        }

        int secondNodeSum = 0;
        while (l2 != null) {
            secondNodeSum = (secondNodeSum * 10) + l2.val;
            l2 = l2.next;
        }

        int sumOfFirstAndSecondNode = firstNodeSum + secondNodeSum;
        ListNode head = new ListNode();
        ListNode tail = head;
        while(sumOfFirstAndSecondNode > 0) {
            int rem = sumOfFirstAndSecondNode % 10;
            ListNode node = new ListNode(rem);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
            sumOfFirstAndSecondNode /= 10;
        }
        if (head.val == 0 && head.next == null) {
            return head;
        } else {
            return head.next;
        }
    }
}