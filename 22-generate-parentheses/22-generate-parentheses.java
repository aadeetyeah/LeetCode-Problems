class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        int open=n-1;
        int close=n;
        generateBrackets(result,new StringBuilder("("),2*n,open,close);
        return result;
    }
    private void generateBrackets(List<String> res,StringBuilder pattern,int size,int open,int close){
        if(pattern.length()==size){
            
            res.add(pattern.toString());
            return;
        }
        
        if(open>0){
            
            generateBrackets(res,pattern.append("("),size,open-1,close);
            pattern.deleteCharAt(pattern.toString().length()-1);
        }
        
        if(close>open){
            generateBrackets(res,pattern.append(")"),size,open,close-1);
            pattern.deleteCharAt(pattern.toString().length()-1);
        }
        return;
    }
}