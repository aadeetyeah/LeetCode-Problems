/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* temp1=new ListNode(-1);
        ListNode* tempHead=temp1;
        int carry=0,num,no;
        while(l1!=NULL and l2!=NULL){
            num=l1->val+l2->val+carry;
            if(num>9){
                carry=num/10;
                no=num%10;
                temp1->next=new ListNode(no);
            }else{
                carry=0;
                temp1->next=new ListNode(num);
            }
            l1=l1->next;
            l2=l2->next;
            temp1=temp1->next;
        }
        while(l1!=NULL){
            num=l1->val+carry;
            if(num>9){
                carry=num/10;
                no=num%10;
                temp1->next=new ListNode(no);
            }else{
                carry=0;
                temp1->next=new ListNode(num);
            }
            temp1=temp1->next;
            l1=l1->next;
        }
        while(l2!=NULL){
            num=l2->val+carry;
            if(num>9){
                carry=num/10;
                no=num%10;
                temp1->next=new ListNode(no);
            }else{
                carry=0;
                temp1->next=new ListNode(num);
            }
            temp1=temp1->next;
            l2=l2->next;
        }
        if(carry==1){
            temp1->next=new ListNode(carry);
        }
        return tempHead->next;
    }
};