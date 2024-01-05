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
    public ListNode swapNodes(ListNode head, int k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        
        int num = 0;
        
        int frontIndex = k-1;
        int rearIndex = arr.size() - k;
        
        num = arr.get(frontIndex);
        arr.set(frontIndex,arr.get(rearIndex));
        arr.set(rearIndex,num);
        
        int ind = 0;
        temp = head;
        while(temp!=null){
            if(temp.val!=arr.get(ind)){
                temp.val = arr.get(ind);
            }
            temp = temp.next;
            ind++;
        }
        return head;
        
    }
}