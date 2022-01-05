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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(-1);
        mergeLists(list1,list2,result);
        return result.next;
    }
    
    public void mergeLists(ListNode l1,ListNode l2,ListNode result){
        if(l1==null){
            result.next=l2;
            return;
        }
        if(l2==null){
            result.next=l1;
            return;
        }
        if(l1.val<l2.val){
            result.next=new ListNode(l1.val);
            mergeLists(l1.next,l2,result.next);
        }else{
            result.next=new ListNode(l2.val);
            mergeLists(l1,l2.next,result.next);
        }
    }
}