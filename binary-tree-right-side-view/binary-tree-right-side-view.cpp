/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        
        std::vector<int> result;
        std::map<int,int> m1;
        rightView(root,0,m1);
        for(auto it : m1){
            result.push_back(it.second);
        }
        return result;
    }
    
    void rightView(TreeNode* root,int hd,std::map<int,int>& m1){
        if(root==NULL){
            return;
        }
        if(m1[hd]==0){
            m1[hd]=root->val;
        }
        rightView(root->right,hd+1,m1);
        rightView(root->left,hd+1,m1);
    }
};