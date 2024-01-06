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
    public int pairSum(ListNode head) {
        
        
        //Find Mid of LinkedList
        
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        
        while(fastPtr!=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = slowPtr;
        
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        int max = 0;
        ListNode lastPartPtr = prev;
        ListNode firstPartPtr = head;
        while(lastPartPtr!=null){
            int sum = lastPartPtr.val + firstPartPtr.val; 
            if(max < sum){
                max = sum;
            }
            lastPartPtr = lastPartPtr.next;
            firstPartPtr = firstPartPtr.next;
        }
        
        return max;
    }
}