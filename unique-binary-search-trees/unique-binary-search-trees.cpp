class Solution {
public:
    int numTrees(int n) {
        std::map<int,int> m1;
        return num_trees(n,m1);
    }
    
    int num_trees(int n,std::map<int,int>& m1){
        if(n==0 || n==1){
            return 1;
        }
        int ways=0;
        if(m1[n]!=0){
            return m1[n];
        }
        for(int itr1=0;itr1<n;itr1++){
            ways+=num_trees(itr1,m1)*num_trees(n-1-itr1,m1);
        }
        m1[n]=ways;
        return ways;
    }
};