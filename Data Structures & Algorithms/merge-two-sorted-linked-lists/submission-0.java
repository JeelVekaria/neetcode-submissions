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

// List1: 2 2 4
// List2: 3 3 5
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode merged = new ListNode();
        ListNode mergedStart = merged;

        if(list1.val<=list2.val) {merged.val = list1.val; list1 = list1.next;}
        else {merged.val = list2.val; list2 = list2.next;}

        while(list1 != null || list2!= null) {
            if(list1 == null) {merged.next = list2; break;}
            if(list2 == null) {merged.next = list1; break;}

            if(list1.val>=list2.val) {
                merged.next = list2;
                merged = merged.next;
                list2 = list2.next;
            } else {
                merged.next = list1;
                merged = merged.next;
                list1 = list1.next;
            }
        }

        return mergedStart;
    }
}






