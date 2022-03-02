class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack<>();
        
        
        for(int itr1=0;itr1<s.length();itr1++){
            if(s.charAt(itr1)=='(' || s.charAt(itr1)=='[' || s.charAt(itr1)=='{'){
                s1.push(s.charAt(itr1));    
            }else{
                if(s1.isEmpty()){
                    return false;
                }
                if(s1.peek()=='(' && s.charAt(itr1)==')'){
                    s1.pop();
                }else if(s1.peek()=='[' && s.charAt(itr1)==']'){
                    s1.pop();
                }else if(s1.peek()=='{' && s.charAt(itr1)=='}'){
                    s1.pop();
                }else{
                    return false;
                }
            }
        }
        if(s1.isEmpty()){
            return true;
        }
        return false;
    }
}