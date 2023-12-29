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
    public ListNode middleNode(ListNode head) {
        ListNode slowptr    =   head;
        ListNode fastptr    =   head;
        
        while(fastptr.next!=null && fastptr.next.next!=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        
        if(fastptr.next!=null){
            return slowptr.next;
        }
        return slowptr;
    }
}