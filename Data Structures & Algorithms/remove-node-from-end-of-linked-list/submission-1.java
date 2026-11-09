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
        ListNode tracker = null;
        ListNode r = head;
        int count = 1;
        while(r != null){
            if(count > n){
                if(tracker == null){
                    tracker = head;
                }else{
                    tracker = tracker.next;
                }
            }
            r = r.next;
            count++;
        }
        if(tracker == null){
            return head.next;
        }else{
            r = tracker.next.next;
            tracker.next = r;
            return head;
        }
    }
}
