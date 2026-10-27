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
        int size = 0;
        ListNode start = head;
        while(start!= null) { 
            start = start.next;
            size++;
        }
        start = head;
        if(size==n) return start.next;
        while(size-n>1) {
            size--;
            start = start.next;
        }
        if(start==null) return null;
        start.next = start.next.next;
        return head;
    }
}
