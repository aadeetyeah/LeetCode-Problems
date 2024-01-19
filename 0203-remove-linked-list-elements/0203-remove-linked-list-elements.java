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
    public ListNode removeElements(ListNode head, int val) {
    
        // return removeElementsIterative(head,val);
        return removeElementsRecursive(head,val);
    }
    
    private ListNode removeElementsRecursive(ListNode head, int val){
        
        if(head==null){
            return null;
        }
        if(head.val == val){
            return removeElementsRecursive(head.next,val);
        }
        
        head.next = removeElementsRecursive(head.next,val);
        return head;
    }
    
    
    public ListNode removeElementsIterative(ListNode head, int val) {
        
        ListNode temp=head;
        ListNode prev=null;
        
        
        while(temp!=null){
            
            if(temp.val == val){
                if(temp!=head){
                    prev.next=temp.next;
                    temp=temp.next;
                }
                if(temp==head){
                    head=head.next;
                    temp=temp.next;
                }
                continue;
            }
            
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
}