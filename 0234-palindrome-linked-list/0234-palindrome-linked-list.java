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
     public boolean isPalindrome(ListNode head) {
        //return checkPalindrome(head);
         if(head.next == null){
             return true;
         }
         ListNode temp = checkPalindromeRecursive(head,head);
         if(temp != null){
             return true;
         }
         return false;
     }
    
    private ListNode checkPalindromeRecursive(ListNode head1,ListNode head2) {
        if(head1.next == null){
            if(head1.val == head2.val){
                return head2.next;
            }else{
                return null;
            }
        }
        ListNode temp = checkPalindromeRecursive(head1.next,head2);
        if(temp!= null && temp.val == head1.val){
            
            if(temp.val == head2.val && temp.next==null){
                return temp;
            }
            return temp.next;
        }
        return null;
    }
    
    
    private boolean checkPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        ListNode cur = slow;
        ListNode prev = null;
        ListNode next = null;
        
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        ListNode rightList = prev;
        ListNode leftList = head;
        
        
        while(rightList!=null){
            if(leftList.val != rightList.val){
                return false;
            }
            leftList = leftList.next;
            rightList = rightList.next;
        }
        return true;
    }
}