class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> finalAns = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        
        createPartition(0,s,finalAns,temp);
        return finalAns;
    }
    
    private void createPartition(int start, String s,List<List<String>> result,
                                 List<String> temp){
        
        if(s.length()==start){
            result.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int itr1=start;itr1<s.length();itr1++){
            
            if(isPalindrome(start,itr1,s)){
                temp.add(s.substring(start,itr1+1));
                createPartition(itr1+1,s,result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(int start,int end,String s){
    
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}