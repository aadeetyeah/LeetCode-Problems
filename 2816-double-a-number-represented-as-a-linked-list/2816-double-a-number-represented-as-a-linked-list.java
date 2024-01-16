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
    public ListNode doubleIt(ListNode head) {
        
        Stack<ListNode> s1 = new Stack<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            s1.push(temp);
            temp = temp.next;
        }
        
        int carry = 0;
        
        while(!s1.isEmpty()){
            temp = s1.pop();
            int num = temp.val;
            num = (num*2) + carry;
            carry = num/10;
            num = num%10 ;
            temp.val = num;            
        }
        
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;     
    }
}