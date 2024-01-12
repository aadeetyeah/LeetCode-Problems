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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseInGroup(head, k);
    }
    
    private ListNode reverseInGroup(ListNode head,int k){
        
        ListNode cur = head;
        ListNode runner = null;
        ListNode temp = null;
        ListNode newHead = null;
        ListNode temp2 = null;
        ListNode prevFirstNode = null;
        
        while(cur != null){
            runner = getPosition(cur,k);
            if(runner == null){
                if(newHead == null){
                    newHead = cur;
                    break;
                }
                prevFirstNode.next = cur;
                break;
            }
            temp = runner.next;
            runner.next = null;
            temp2 = reverseList(cur);
            if(newHead == null){
                newHead = temp2;
            }else{
                prevFirstNode.next = temp2;
            }
            prevFirstNode = cur;
            cur = temp;
        }
        return newHead;
    }
    
    private ListNode getPosition(ListNode head, int k){
        
        ListNode temp = head;
        int cnt = 1;
        while(temp.next != null && cnt != k){
            temp = temp.next;
            cnt++;
        }
        if(cnt!=k){
            return null;
        }
        return temp;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur  = head;
        ListNode next = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}