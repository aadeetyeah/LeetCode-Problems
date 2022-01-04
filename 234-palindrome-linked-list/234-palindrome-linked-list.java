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
        ListNode head1=head;
        ListNode head2=new ListNode(-1);
        ListNode tempHead=head2;
        
        while(head!=null){
            head2.next=new ListNode(head.val);
            head=head.next;
            head2=head2.next;
        }
        
        head2=tempHead.next;
        ListNode prev=null;
        head2=reverseList(head2,prev);
        return is_palindrome(head1,head2);
    }
    
    public ListNode reverseList(ListNode head,ListNode prev){
        if(head==null){
            return prev;
        }
        ListNode temp=head.next;
        head.next=prev;
        return reverseList(temp,head);
    }
    
    public boolean is_palindrome(ListNode head,ListNode head2){
        if(head==null && head2==null){
            return true;
        }
        if(head.val!=head2.val){
            return false;
        }
        return is_palindrome(head.next,head2.next);
    }
}