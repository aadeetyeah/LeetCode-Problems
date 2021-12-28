class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int count=0;
        int prefix_sum=0;
        int temp;
        std::map<int,int> m1;
        m1[prefix_sum]=1;
        for(int itr1=0;itr1<nums.size();itr1++){
            prefix_sum+=nums[itr1];
            temp=((prefix_sum%k)+k)%k;
            if(m1[temp]!=0){
                
                count+=m1[temp];
                m1[temp]++;
            }else{
                m1[temp]=1;
            }
        }
        return count;
    }
};