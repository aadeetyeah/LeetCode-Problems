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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head.next == null){
            return head;
        }
        
        ListNode rearPtr  = head;
        ListNode frontPtr = head;
        ListNode front    = null;
        ListNode rear     = null;
        
        //Setting the frontPtr and RearPtr at left and right position resp.
        for(int itr1=1;itr1<left;itr1++){
            front    = frontPtr;
            frontPtr = frontPtr.next;
        }
        
        for(int itr1=1;itr1<right;itr1++){
            rearPtr = rearPtr.next;
        }
        rear         = rearPtr.next;
        rearPtr.next = null;
        
        ListNode cur  = frontPtr;
        ListNode prev = null;
        ListNode next = null;
        
        //reverse logic
        while(cur != null){
            next     = cur.next;
            cur.next = prev;
            prev     = cur;
            cur      = next;
        }
        
        if(left == 1){
            head = prev;
        }else{
            front.next = prev;
        }
        frontPtr.next = rear;
        
        
        return head;
    }
}