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
    public ListNode rotateRight(ListNode head, int k) {
        
        int cnt = 1;
        ListNode temp  = head;
        ListNode temp2 = head;
        
        if(head == null || k == 0){
            return head;
        }
        
        while(temp.next != null){
            temp = temp.next;
            cnt++;
        }
        
        while(k > cnt){
            k = k - cnt;    
        }
        
        if(cnt == 1 || cnt == k){
            return head;
        }
        
        
        int k2 = cnt - k - 1;
        
        for(int itr1=0;itr1<k2;itr1++){
            temp2 = temp2.next;
        }
        
        ListNode newHead = temp2.next;
        temp.next = head;
        temp2.next = null;
        return newHead;
        
        
    }
}