class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        std::map<std::string,int> m1;
        return target_sum_ways(0,nums,target,m1);
    }
    
    int target_sum_ways(int start,vector<int>& nums,int target,std::map<std::string,int>& m1){
        if(target==0 && start==nums.size()){
            return 1;
        }
        if(start>=nums.size()){
            return 0;
        }
        string str1="";
        str1=str1+to_string(start)+"*"+to_string(target);
        if(m1.find(str1)!=m1.end()){
            return m1[str1];
        }
        int pos=target_sum_ways(start+1,nums,target-nums[start],m1);
        int neg=target_sum_ways(start+1,nums,target+nums[start],m1);
        m1[str1]=pos+neg;
        return pos+neg;
    }
};