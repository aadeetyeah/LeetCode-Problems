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
    bool hasCycle(ListNode *head) {
        return check_cycle(head);
    }
    bool check_cycle(ListNode *head){
        if(head==NULL){
            return false;
        }
        if(head==head->next){
            return true;
        }
        ListNode *temp=head;
        std::set<ListNode*> s1;
        while(temp->next!=NULL){
            if(s1.find(temp)!=s1.end()){
                return true;
            }
            s1.insert(temp);
            temp=temp->next;
        }
        return false;
    }
};