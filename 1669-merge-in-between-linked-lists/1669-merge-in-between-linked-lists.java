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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode temp = list1;
        ListNode prev = null;
        ListNode temp2Last = list2;
        
        while(temp2Last.next!=null){
            temp2Last = temp2Last.next;
        }
        int cnt = 0;
        while(temp!=null){
            if(cnt == a){
                prev.next = list2; 
            }
            if(cnt == b){
                temp2Last.next = temp.next;
                break;
            }
                
            prev = temp;
            temp = temp.next;
            cnt++;
        }
        return list1;
    }
}