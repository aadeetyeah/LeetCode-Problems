/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ArrayList<ListNode> cache = new ArrayList<>();
        
//         ListNode temp = headA;
//         while(temp!=null){
//             cache.add(temp);
//             temp=temp.next;
//         }
        
//         temp=headB;
//         while(temp!=null){
//             if(cache.contains(temp)){
//                 return temp;
//             }
//             temp=temp.next;
//         }
//         return null;
//     }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode tempA= headA;
        ListNode tempB= headB;
        
        while(tempA!=tempB){
            
            if(tempA==null){
                tempA=headB;
            }else{
                tempA=tempA.next;
            }
            
            if(tempB==null){
                tempB=headA;
            }else{
                tempB=tempB.next;
            }
        }
        return tempA;
    }
}