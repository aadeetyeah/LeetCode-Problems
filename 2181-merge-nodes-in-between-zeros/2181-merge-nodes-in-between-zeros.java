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
    public ListNode mergeNodes(ListNode head) {
        ListNode tempList = null;
        
        ListNode finalList = tempList;
        
        int sum=0;
        ListNode temp = head;
        while(temp!=null){
            sum+=temp.val;
            if(temp.val==0 && temp!=head){
                ListNode tempNode = new ListNode(sum);
                sum=0;
                if(tempList==null){
                    tempList = tempNode;
                    finalList = tempList;
                }else{
                    tempList.next=tempNode;
                    tempList = tempList.next;
                }
            }
            temp = temp.next;
        }
        return finalList;
    }
}