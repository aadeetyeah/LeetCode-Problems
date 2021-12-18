class Solution {
public:
    bool isSubsequence(string s, string t) {
        return is_subsequence(0,0,t,s);
    }
    
    bool is_subsequence(int start1,int start2,string s1,string s2){
        if(start2>=s2.size()){
            return true;
        }
        
        if(start1>=s1.size() && start2<s2.size()){
            return false;
        }
        if(s1.at(start1)==s2.at(start2)){
            return is_subsequence(start1+1,start2+1,s1,s2);
        }else{
            return is_subsequence(start1+1,start2,s1,s2);
        }
    }
};