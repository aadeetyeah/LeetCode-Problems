/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> s1=new HashSet<>();
        ListNode temp=head;
        ListNode t1=null;
        if(head==null){
            return t1;
        }
        while(temp.next!=null){
            if(s1.contains(temp))
                return temp;
            s1.add(temp);
            temp=temp.next;
        }
        return t1;
    }
}