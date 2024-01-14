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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> memo = new HashMap<>();
        
        ListNode temp = head;
        ListNode node = new ListNode(-1);
        node.next = temp;
        memo.put(0,node);
        
        int sum = 0;
        while(temp != null){
            sum+=temp.val;
            
            if(memo.containsKey(sum)){
                ListNode var = memo.get(sum).next;
                int tSum = sum;
                while(var != temp){
                    tSum+= var.val;
                    memo.remove(tSum);
                    var = var.next;
                }
                var = memo.get(sum);
                System.out.println(var.val);
                var.next = temp.next;
            }else{
                memo.put(sum,temp);
                
            }
             temp = temp.next;   
        }
        
        return node.next;
    }
}