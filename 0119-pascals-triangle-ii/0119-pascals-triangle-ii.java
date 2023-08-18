class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> l1=new ArrayList<Integer>();
        l1.add(1);
        
        if(rowIndex==0){
            return l1;
        }
        
        List<List<Integer>> result= new ArrayList();
        result.add(l1);
        
        for(int itr1=1;itr1<=rowIndex;itr1++){
            List<Integer> l2    =   new ArrayList<Integer>();
            l2.add(1);
            for(int itr2=1;itr2<itr1;itr2++){
                int sum = result.get(itr1-1).get(itr2-1)+result.get(itr1-1).get(itr2);
                l2.add(sum);
            }
            l2.add(1);
            result.add(l2);
        }
        
        return result.get(result.size()-1);
    }
}