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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode prev   = null;
        ListNode travel = head;
        ListNode temp   = null;
        
        while(travel != null && travel.next != null){
            
            if(travel.val == travel.next.val){
                temp = travel.next;
                
                while(temp != null){
                    if(travel.val != temp.val){
                        if(prev == null){
                            head = temp;
                            prev = null;
                        }else{
                            prev.next = temp;
                        }
                        break;
                    }
                    temp = temp.next;
                }
                if(temp == null){
                    if(prev == null){
                        return null;
                    }else{
                        prev.next = null;
                        return head;
                    }
                }
                travel = temp;
            }else{
                prev = travel;
                travel = travel.next;
            }
        }
        return head;
    }
}