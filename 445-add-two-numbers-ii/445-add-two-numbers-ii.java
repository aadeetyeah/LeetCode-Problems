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
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int data=0;
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        ListNode temp=new ListNode(-1);
        ListNode temp1=null;
        ListNode first=null;
        int carry=0;
        while(!s1.isEmpty() && !s2.empty()){
            data=s1.pop();
            data+=s2.pop();
            if(carry!=0){
                data+=carry;
                carry=0;
            }
            if(data>9){
                carry=data/10;
                data=data%10;
            }
            if(first==null){
                first=new ListNode(data);
            }else{
                temp1=new ListNode(data);
                temp1.next=first;
                first=temp1;
            }
            data=0;
            
        }
        while(!s1.empty()){
            data=s1.pop();
            if(carry!=0){
                data+=carry;
                carry=0;
            }
            if(data>9){
                carry=data/10;
                data=data%10;
            }
            temp1=new ListNode(data);
                temp1.next=first;
                first=temp1;
        }
        while(!s2.empty()){
            data=s2.pop();
            if(carry!=0){
                data+=carry;
                carry=0;
            }
            if(data>9){
                carry=data/10;
                data=data%10;
            }
            temp1=new ListNode(data);
                temp1.next=first;
                first=temp1;
        }
        if(carry!=0){
            temp1=new ListNode(carry);
                temp1.next=first;
                first=temp1;
        }
        return first;
    }
    
    private ListNode reverse(ListNode l1){
       ListNode previous=null;
        ListNode next=null;
        ListNode current=l1;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            
        }
        return previous;
        
    }
    
    private ListNode addTwoList(ListNode l1,ListNode l2){
        int carry=0;
        ListNode temp=new ListNode(-1);
        ListNode temp1=temp;
        int data=0;
        
        while(l1!=null && l2!=null){
            data=l1.val+l2.val;
            if(carry!=0){
                data+=carry;
                carry=0;
            }
            if(data>9){
                data=data%10;
                carry=data/10;
            }
            temp1.next=new ListNode(data);
            temp1=temp1.next;
            l1=l1.next;
            l2=l2.next;
            data=0;
        }
        while(l1!=null){
            if(carry!=0){
                data=l1.val+carry;
                carry=0;
            }
            if(data>9){
                data=data%10;
                carry=data/10;
            }
            temp1.next=new ListNode(data);
            temp1=temp1.next;
            data=0;
        }
        
        while(l2!=null){
            if(carry!=0){
                data=l2.val+carry;
                carry=0;
            }
            if(data>9){
                data=data%10;
                carry=data/10;
            }
            temp1.next=new ListNode(data);
            temp1=temp1.next;
            data=0;
        }
        if(carry!=0){
            temp1.next=new ListNode(carry);
        }
        temp1=reverse(temp.next);
        return temp1;
    }
}