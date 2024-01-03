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
        Set<ListNode> cache = new HashSet<>();
        
        ListNode temp = head;
        while(temp!=null){
            
            if(cache.contains(temp)){
                return true;
            }
            cache.add(temp);
            temp = temp.next;
        }
        return false;
    }
}