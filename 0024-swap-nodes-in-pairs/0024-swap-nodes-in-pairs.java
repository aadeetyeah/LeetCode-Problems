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
    public ListNode swapPairs(ListNode head) {
     
        //return swapIterative(head);
        head = swapRecursive(head);
        return head;
    }
    
    private ListNode swapRecursive(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;
        head.next.next = swapRecursive(head.next.next);
        return head;
    }
    
    public ListNode swapIterative(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur  = head;
        ListNode newHead = null;
        
        if(head == null || head.next == null){
            return head;
        }
        while(cur != null && cur.next != null){
            next = cur.next.next;
            temp = cur.next;
            if(newHead == null){
                newHead = cur.next;
            }
            temp.next = cur;
            cur.next = next;
            if(prev != null){
                prev.next = temp;
            }
            prev = cur;
            cur = next;
        }
        return newHead;
    }
}