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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        ListNode gap = head;
        // 1 2 3 4 5, n=2
        while(n>0) {
            gap = gap.next;
            n--;
        }

        if(gap == null) return head.next;

        while(gap.next != null) {
            start = start.next;
            gap = gap.next;
        }

        start.next = start.next.next;
        return head;

        
    }
}
