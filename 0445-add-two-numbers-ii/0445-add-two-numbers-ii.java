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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while(temp1 != null){
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }
        
        int carry =0;
        ListNode temp = null;
        ListNode result = null;
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            
            int t1 =0, t2 =0;
            if(!stack1.isEmpty()){
                t1 = stack1.pop();
            }
            if(!stack2.isEmpty()){
                t2 = stack2.pop();
            }
            
            
            int num = t1+t2+carry;
            carry = num/10;
            num = num%10;
            
            ListNode newNode = new ListNode(num);
            
            if(result == null){
                result = newNode;
            }else{
                temp = result;
                result = newNode;
                result.next = temp;
            }
            
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            temp = result;
            result = newNode;
            result.next = temp;
        }
        
        return result;
    }
}