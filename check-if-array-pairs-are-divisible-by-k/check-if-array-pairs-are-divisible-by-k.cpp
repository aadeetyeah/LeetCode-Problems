class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        std::map<int,int> m1;
        int rem;
        for(int itr1=0;itr1<arr.size();itr1++){
            rem=((arr[itr1]%k)+k)%k;
            if(m1[rem]==0){
                m1[rem]=1;
            }else{
                m1[rem]++;
            }
        }
        for(auto it : m1){
            if(it.first==0 && it.second%2==1){
                std::cout<<"Hello\n";
                return false;
            }else if(it.first!=0 and it.second != m1[k-it.first]){
                std::cout<<"Hello2"<<it.second<<" "<<it.first<<" "<<k-it.first<<"\n";
                return false;
            }
        }
        return true;
    }
};