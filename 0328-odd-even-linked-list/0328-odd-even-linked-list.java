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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddList = null;
        ListNode evenList = null;
        
        ListNode temp = head;
        
        ListNode oddHead = null;
        ListNode evenHead = null;
        
        if(head == null){
            return null;
        }
        
        int ind = 0;
        while(temp!=null){
            if(ind%2==0){
                if(oddHead == null){
                    oddHead = new ListNode(temp.val);
                    oddList = oddHead;
                }else{
                    oddList.next = new ListNode(temp.val);
                    oddList = oddList.next;
                }
            }else{
                if(evenHead == null){
                    evenHead = new ListNode(temp.val);
                    evenList = evenHead;
                }else{
                    evenList.next = new ListNode(temp.val);
                    evenList = evenList.next;
                }
            }
            
            ind++;
            temp = temp.next;
        }
        
        oddList.next = evenHead;
        
        return oddHead;
    }
}