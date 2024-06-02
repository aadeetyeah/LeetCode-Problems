class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalAns = new ArrayList<>();
        
        combineUtil(1,n,k,finalAns,new ArrayList<Integer>());
        return finalAns;
    }
    
    private void combineUtil(int start, int n,int k,List<List<Integer>> finalAns, List<Integer> temp){
        
        if(temp.size()==k){
            finalAns.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int itr1=start;itr1<=n;itr1++){
            temp.add(itr1);
            combineUtil(itr1+1,n,k,finalAns,temp);
            temp.remove(temp.size()-1);
        }
        return;
    }
}