/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* temp1=NULL;
        node->val=node->next->val;
        temp1=node->next;
        node->next=temp1->next;
        delete temp1;
        temp1=NULL;
        
        
    }
};