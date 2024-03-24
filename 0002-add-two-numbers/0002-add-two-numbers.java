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
        int carry = 0;
        // return addTwoNumbersIterative(l1,l2);
        return addTwoNumbersRecursive(l1,l2,carry);
    }
    
    public ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2,int carry) {
        int num = 0;       
        
        if(l1 == null && l2!=null){
            num = l2.val + carry;    
        }
        if(l2 == null && l1!=null){
            num = l1.val + carry;
        }
        if(l1 != null && l2 != null){
            num = l1.val + l2.val + carry;
        }
        
        if(l1 == null && l2==null){
            if(carry!=0){
                return new ListNode(carry);
            }else{
                return null;
            }
        }
            
        carry = 0;
        if(num>9){
            carry = num/10;
            num = num%10;
        }
        
        ListNode newNode = new ListNode(num);
        
        if(l1!=null && l2 == null){
            newNode.next = addTwoNumbersRecursive(l1.next,null,carry);
        }
        
        if(l2!=null && l1==null){
            newNode.next = addTwoNumbersRecursive(null,l2.next,carry);
        }
        
        if(l2!=null && l1!=null){
            newNode.next = addTwoNumbersRecursive(l1.next,l2.next,carry);
        }
            
        return newNode;
    }
        
    
    public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        
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

        return newHead;
    }
}