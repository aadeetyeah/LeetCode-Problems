class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        
        List<Integer> ans=new ArrayList<>();
        ans.add(1);
        result.add(ans);
        if(numRows==1){
            return result;
        }
        
        ans=new ArrayList<Integer>();
            ans.add(1);
            ans.add(1);
            result.add(ans);
            
        if(numRows==2){
            return result;
        }
        
        
        pascal(numRows,result);
        return result;
    }
    
    private void pascal(int numRows,List<List<Integer>> result){
            
        List<Integer> temp=result.get(1);
        int mem=0;
        
        for(int itr2=2;itr2<numRows;itr2++){
            List<Integer> ans=new ArrayList<>();
            ans.add(1);
            temp=result.get(itr2-1);
            
            for(int itr1=1;itr1<temp.size();itr1++){
                mem=temp.get(itr1-1)+temp.get(itr1);
                ans.add(mem);
            }
            
            ans.add(1);
            result.add(new ArrayList<Integer>(ans));   
        }   
    }
}