class Solution {
public:
    int numSquares(int n) {
        int n1=1;
        int n2=sqrt(n);
        std::vector<std::vector<int>> v1(n2+1,std::vector<int>(n+1,0));
        return count_min_count(n1,n2,n,v1);   
    }
    
    int count_min_count(int start,int end,int Target,std::vector<std::vector<int>>& m1){
        if(start>end){
            return INT_MAX;
        }
        if(Target==0){
            return 0;
        }
        int num=start*start;
        if(num>Target){
            return INT_MAX;
        }
        //std::string key=to_string(start)+"_"+to_string(Target);
        if(m1[start][Target]!=0){
            return m1[start][Target];
        }
        int consider=0;
        consider=count_min_count(start,end,Target-num,m1);
        if(consider!=INT_MAX){
            consider++;
        }
        int notConsider=0;
        notConsider=count_min_count(start+1,end,Target,m1);
        m1[start][Target]=std::min(consider,notConsider);
        return m1[start][Target];
    }
};