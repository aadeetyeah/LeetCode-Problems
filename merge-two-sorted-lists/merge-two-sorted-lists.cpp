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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* temp1=new ListNode(-1);
        ListNode* t_head=temp1;
        ListNode* l1=list1;
        ListNode* l2=list2;
        while(l1!=NULL && l2!=NULL){
            if(l1->val <l2->val){
                temp1->next=new ListNode(l1->val);
                temp1=temp1->next;
                l1=l1->next;
            }else{
                temp1->next=new ListNode(l2->val);
                temp1=temp1->next;
                l2=l2->next;
            }
        }
        if(l1!=NULL){
            temp1->next=l1;
        }
        if(l2!=NULL){
            temp1->next=l2;
        }
        temp1=t_head->next;
        delete t_head;
        return temp1;
    }
};