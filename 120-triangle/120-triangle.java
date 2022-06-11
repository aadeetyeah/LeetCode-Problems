class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String,Integer> m1=new HashMap<>();
        return minSum(0,0,triangle,m1);
    }
    
    private int minSum(int row,int col,List<List<Integer>> triangle,Map<String,Integer> m1){
        String key=Integer.toString(row)+"_"+Integer.toString(col);
        if(m1.containsKey(key)){
            return m1.get(key);
        }
        if(row==triangle.size()){
            return 0;
        }
        
        
        int left=minSum(row+1,col,triangle,m1);
        int right=minSum(row+1,col+1,triangle,m1);
        int res=Math.min(left,right);
        
        m1.put(key, res+triangle.get(row).get(col));
        return m1.get(key);
    }
}