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
// null 1 2 3 4 5 null
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = head.next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
        // ListNode curHead = head;
        // if(head.next!= null) {
        //     curHead = reverseList(curHead.next);
        //     head.next.next = head;
        // }
        // head.next = null;

        // return curHead;
    }
}
