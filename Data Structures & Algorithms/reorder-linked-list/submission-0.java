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
    public void reorderList(ListNode head) {
        ListNode firstHalf = null, secondHalf = head, r = null;
        while(secondHalf != null){
            if(firstHalf == null){
                firstHalf = head;
            }else{
                firstHalf = firstHalf.next;
            }
            for(int i = 0; i < 2; i++){
                if(secondHalf != null){
                    secondHalf = secondHalf.next;
                }
            }
        }
        // reverse second half
        secondHalf = firstHalf.next;
        firstHalf.next = null;
        while(secondHalf != null){
            var t1 = secondHalf.next;
            secondHalf.next = r;
            r = secondHalf;
            secondHalf = t1;
        }
        var c = head;
        ListNode com = null;
        while(c != null){
            var t1 = c.next;
            c.next = null;
            if(com != null){
                com.next = c;
            }
            com = c;
            c = t1;
            if(r != null){
                var t2 = r.next;
                r.next = null;
                com.next = r;
                com = com.next;
                r = t2;
            }
        }
    }
}
