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
    public boolean hasCycle(ListNode head) {
        var currentNode = head;
      while(currentNode != null && currentNode.next != null){
        if(currentNode.val == Integer.MIN_VALUE){
            return true;
        }
        currentNode.val = Integer.MIN_VALUE;
        currentNode = currentNode.next.next;
      }  
      return false;
    }
}
