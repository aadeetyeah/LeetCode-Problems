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
        ListNode prev=null;
        return recursiveReverse(head,prev);
    }
    public ListNode recursiveReverse(ListNode head,ListNode prev){
        if(head==null){
            return prev;
        }
        ListNode temp=head.next;
        head.next=prev;
        return recursiveReverse(temp,head);
        
    }
}