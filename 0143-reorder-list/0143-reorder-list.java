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
        reorderListRecursive(head,head);
    }
    
    private ListNode reorderListRecursive(ListNode head1,ListNode head2){
        if(head2.next == null){
            return head1;
        }
        ListNode temp = reorderListRecursive(head1,head2.next);
        
        if(temp == null || temp.next == null || temp == head2){
            return null;
        }
        
        ListNode leftNext = temp.next;
        temp.next = head2.next;
        head2.next = null;
        temp.next.next = leftNext;
        return temp.next.next;
    }
}