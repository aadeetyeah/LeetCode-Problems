class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        std::map<std::string,int> m1;
        std::map<std::string,int> m2;
        
        for(int itr1=0;itr1<words1.size();itr1++){
            if(m1[words1[itr1]]==0){
                m1[words1[itr1]]=1;
            }else{
                m1[words1[itr1]]++;
            }
        }
        for(int itr1=0;itr1<words2.size();itr1++){
            if(m2[words2[itr1]]==0){
                m2[words2[itr1]]=1;
            }else{
                m2[words2[itr1]]++;
            }
        }
        int cnt=0;
        for(int itr1=0;itr1<words1.size();itr1++){
            
            if(m1[words1[itr1]]==m2[words1[itr1]] && m1[words1[itr1]]==1){
                cnt++;
            }   
        }
        return cnt;
    }
};