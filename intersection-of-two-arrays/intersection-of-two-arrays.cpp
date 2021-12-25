class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        std::set<int> s1;
        std::map<int,int> m1;
        for(int itr1=0;itr1<nums1.size();itr1++){
            if(m1[nums1[itr1]]==0){
                m1[nums1[itr1]]=1;
            }else{
                m1[nums1[itr1]]++;
            }
        }
        for(int itr1=0;itr1<nums2.size();itr1++){
            if(m1[nums2[itr1]]!=0){
                s1.insert(nums2[itr1]);
            }
        }
        std::vector<int> v1(s1.begin(),s1.end());
        return v1;
    }
};