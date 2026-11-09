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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = null, c = null;
        var n1 = list1;
        var n2 = list2;
        while((n1 != null) | (n2 != null)){
            ListNode n = null;
            if(n2 == null){
                if(h == null){
                    return n1;
                }else{
                    c.next = n1;
                    return h;
                }
            }
            if(n1 == null){
                if(h == null){
                    return n2;
                }else{
                    c.next = n2;
                    return h;
                }
            }
            if(n1.val <= n2.val){
                n = n1;
                n1 = n1.next;
            }else{
                n = n2;
                n2 = n2.next;
            }
            if(h == null){
                c = n;
                h = c;
            }else{
                c.next = n;
                c = n;
            }
        }
        return h;
    }
}