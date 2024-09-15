class Solution {
    private void generate(int n, int open, int closed, String str, List<String> res){
        
        if(closed==n){
            res.add(str);
            return;
        }
        if(open<n){
            generate(n,open+1,closed,str+'(',res);
        }
        if(closed<open){
            generate(n,open,closed+1,str+')',res);
        }
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n,0,0,"",res);
        return res;
    }
}