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
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prev = null;
        
        if(head.next==null || head == null){
            return null;
        }
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }
        
        if(fastPtr.next != null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }
        
        prev.next = slowPtr.next;
        
        return head;
    }
}