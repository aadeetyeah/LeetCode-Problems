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
        
        int carry = 0;
        int remainder = 0;
        ListNode newList = null;
        ListNode newHead = null;
        int num = 0;
        while(temp1!=null || temp2!=null){
            
            if(temp1 == null){
                num = temp2.val + carry;    
            }
            if(temp2 == null){
                num = temp1.val + carry;
            }
            
            if(temp1 != null && temp2 != null){
                num = temp1.val + temp2.val + carry;
            }
            
            carry = 0;
            if(num>9){
                carry = num/10;
                num = num%10;
            }
            ListNode newNode = new ListNode(num);
            if(newList == null){
                newList = newNode;
                newHead = newList;
            }else{
                newList.next = newNode;
                newList = newList.next;
            }
            
            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;    
            }
        }
        
        if(carry!=0){
            newList.next = new ListNode(carry);
        }
//         while(temp2 != null){
//             int num = temp2.val + carry;
            
//             carry = 0;
//             if(num > 9){
//                 carry = num/10;
//                 num = num%10;
//             }
//             ListNode newNode = new ListNode(num);
//             newList.next = newNode;
//             newList = newList.next;
            
//             temp2 = temp2.next;
//         }
        return newHead;
    }
}