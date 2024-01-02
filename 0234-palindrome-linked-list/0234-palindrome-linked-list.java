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