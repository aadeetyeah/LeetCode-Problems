class Solution {
public:
    bool isAnagram(string s, string t) {
        std::map<char,int> m1;
        if(s.size()!=t.size()){
            return false;
        }
        for(int itr1=0;itr1<s.size();itr1++){
            if(m1[s.at(itr1)]==0){
                m1[s.at(itr1)]=1;
            }else{
                m1[s.at(itr1)]++;
            }
        }
        for(int itr1=0;itr1<t.size();itr1++){
            m1[t.at(itr1)]--;
            if(m1[t.at(itr1)]==0){
                m1.erase(t.at(itr1));
            }
        }
        if(m1.size()>0){
            return false;
        }else{
            return true;
        }
    }
};