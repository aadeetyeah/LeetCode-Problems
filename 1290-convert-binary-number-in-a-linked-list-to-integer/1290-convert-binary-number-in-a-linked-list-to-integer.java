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
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> biNumList = new ArrayList<>();
        
        ListNode ptr=head;
        while(ptr!=null){
            biNumList.add(ptr.val);
            ptr=ptr.next;
        }
        
        int  size=biNumList.size();
        double num=0;
        double index=0;
        for(int itr1=size-1;itr1>=0;itr1--){
            double power   =   Math.pow(2,index);
            num =   num + biNumList.get(itr1)*power;
            index++;
        }
        return (int)num;
    }
}