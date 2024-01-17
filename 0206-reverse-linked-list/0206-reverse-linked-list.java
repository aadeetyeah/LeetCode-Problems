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
        
        // return reverseListItr(head);
        ListNode newHead  = null;
        return reverseRecursive(head,null,newHead);
    }
    
    private ListNode reverseListItr(ListNode head){
        
        ListNode cur    =   null;
        ListNode prev   =   null;
        ListNode next   =   null;
        ListNode temp   =   head;
        
        while(temp!=null){
            cur     = temp;
            next    = temp.next;
            cur.next    =   prev;
            prev    = cur;
            temp    = next;
        }
        return cur;
    }
    
    private ListNode reverseRecursive(ListNode head,ListNode prev, ListNode newHead){
        if(head == null){
            return null;
        }
        newHead = reverseRecursive(head.next,head,newHead);
        if(head.next==null){
            newHead = head;
        }
        head.next = prev;
        return newHead;
    }
}

