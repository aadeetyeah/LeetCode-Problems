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
    public ListNode removeNodes(ListNode head) {
        
        
        ListNode revList = reverse(head);
        ListNode temp = revList;
        ListNode newList = null;
        ListNode newHead = null;
        int max = 0;
        while(temp != null){
            if(temp.val >= max){
                max = temp.val;
                ListNode tNode = new ListNode(max);
                if(newHead == null){
                    newHead = tNode;
                    newList = newHead;
                }else{
                    newList.next = tNode;
                    newList = newList.next;
                }
            }
            temp = temp.next;
        }
        
        return reverse(newHead);
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur  = head;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}