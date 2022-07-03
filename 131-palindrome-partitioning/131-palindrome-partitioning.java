class Solution {
    public List<List<String>> partition(String s) {
        List<String> temp=new ArrayList<>();
        List<List<String>> answer=new ArrayList<>();
        getPalindromePart(s,temp,answer);
        return answer;
    }
    
    private void getPalindromePart(String s,List<String> temp,List<List<String>> answer){
        
        if(s==""){
            answer.add(new ArrayList<>(temp));
            return;
        }
        
        String str1="";
        for(int itr1=0;itr1<s.length();itr1++){
            str1+=s.charAt(itr1);
            if(isPalindrome(str1)){
                temp.add(str1);
                getPalindromePart(s.substring(itr1+1),temp,answer);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str1){
        if(str1.length()==1){
            return true;
        }
        int start=0;
        int end=str1.length()-1;
        
        while(start<end){
            if(str1.charAt(start)!=str1.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}