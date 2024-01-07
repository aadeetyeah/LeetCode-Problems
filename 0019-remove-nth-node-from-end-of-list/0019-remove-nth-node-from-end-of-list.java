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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null && n==1){
            return null;
        }
        ListNode temp = head;
        ListNode sTemp = head;
        
        for(int itr1=0; itr1<n; itr1++){
            temp = temp.next;
        }
        
        if(temp==null){
            return head.next;
        }
        while(temp.next!=null){
            sTemp = sTemp.next;
            temp = temp.next;
        }
        
        sTemp.next = sTemp.next.next;
        return head;
    }
}