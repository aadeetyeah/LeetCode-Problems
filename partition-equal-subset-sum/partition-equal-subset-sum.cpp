class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(auto it : nums){
            sum+=it;
        }
        
        if(sum%2==1){
            return false;
        }
        std::vector<std::vector<int>> v1(nums.size(),std::vector<int>((sum/2)+1,-1));
        return subsetExists(0,nums,sum/2,v1);
    }
    
    bool subsetExists(int start,std::vector<int>& nums,int target,std::vector<std::vector<int>>& v1){
        if(target==0){
            
            return 1;
        }
        if(start>=nums.size()){
            return 0;
        }
        int include=0;
        
        if(v1[start][target]!=-1){
           return v1[start][target];
        }
        if(target>=nums[start]){
            include=subsetExists(start+1,nums,target-nums[start],v1);    
        }
        int exclude=subsetExists(start+1,nums,target,v1);
        
        v1[start][target]= include or exclude;
        return v1[start][target];
        
    }
};