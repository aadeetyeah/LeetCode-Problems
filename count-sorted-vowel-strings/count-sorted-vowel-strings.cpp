class Solution {
public:
    int countVowelStrings(int n) {
        char vowels[5];
        vowels[0]='a';
        vowels[1]='e';
        vowels[2]='i';
        vowels[3]='o';
        vowels[4]='u';
        char ch='a';
        ch--;
        if(n==1){
            return 5;
        }
        std::map<std::string,int> m1;
        int cnt=0;
        for(int itr1=0;itr1<5;itr1++){
         cnt+=count_vowels(vowels,itr1,5,n-1,ch,m1);
        }
        return cnt;
    }
    
    int count_vowels(char* vowels,int start,int size,int n,char previous,std::map<std::string,int>& m1){
       
        
        if(vowels[start]<previous ){
            return 0;
        }
        if(n==0){
            return 1;
        }
        std::string key=to_string(start)+"_"+to_string(n)+"_"+to_string(previous);
        if(m1[key]!=0){
            return m1[key];
        }
        int cnt=0;
        for(int itr1=0;itr1<5;itr1++){
            std::cout<<itr1<<"--"<<cnt<<endl;
            cnt=cnt+count_vowels(vowels,itr1,size,n-1,vowels[start],m1);
            std::cout<<itr1<<"--"<<cnt<<endl;
        }
        m1[key]=cnt;
        return cnt;
    }
};