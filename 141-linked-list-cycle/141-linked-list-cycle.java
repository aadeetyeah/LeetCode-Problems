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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s1=new HashSet<>();
        ListNode temp=head;
        if(head==null){
            return false;
        }
        while(temp.next!=null){
            if(s1.contains(temp))
                return true;
            s1.add(temp);
            temp=temp.next;
        }
        return false;
    }
}