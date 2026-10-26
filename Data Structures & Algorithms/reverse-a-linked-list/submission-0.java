/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// null <- 1 <- 2 -> 3 -> null  2 -> 1
// 3 -> 2 -> null
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode newHead = head;

        if(head.next != null) {
            newHead = reverseList(newHead.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }
}
