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
    public ListNode reverseList(ListNode head) {
        ListNode n = head;
        ListNode reversed = null;
        while(n != null){
            ListNode t = n.next;
            if(reversed == null){
                reversed = n;
                n.next = null;
            }else{
                n.next = reversed;
                reversed = n;
            }
            n = t;
        }
        return reversed;
    }
}
