class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> combo_list;
        vector<int> current_arr;
        combo_sum(0,candidates,target,current_arr,combo_list);
        return combo_list;
    }
    
    void combo_sum(int start,std::vector<int>& candidates,int target,std::vector<int>& curr_arr,std::vector<std::vector<int>>& combo_list){
        if(target==0){
            combo_list.push_back(curr_arr);
            return;
        }
        if(start>=candidates.size()){
            return;
        }
        if(target>=candidates[start]){
            curr_arr.push_back(candidates[start]);
            combo_sum(start,candidates,target-candidates[start],curr_arr,combo_list);
            curr_arr.pop_back();
        }
        combo_sum(start+1,candidates,target,curr_arr,combo_list);
        return;
    }
};