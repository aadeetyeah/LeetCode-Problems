class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Map<String,Integer> memo = new HashMap<>();
        // return minTotal(0,0,triangle,memo);
        return minTotalIterative(triangle);
    }

    private int minTotalIterative(List<List<Integer>> triangle){
        int dp[][] = new int[triangle.size()][triangle.size()];
        int lastRowInd = triangle.size()-1;
        int lastRowLen = triangle.get(lastRowInd).size();
        //Base Condition.
        for(int itr1 = 0;itr1<lastRowLen; itr1++){
            dp[lastRowInd][itr1] = triangle.get(lastRowInd).get(itr1); 
        }

        int len = triangle.size();
        for(int itr1 = len-2;itr1>=0;itr1--){
            for(int itr2=itr1; itr2>=0; itr2--){
                int down = triangle.get(itr1).get(itr2) + 
                            dp[itr1+1][itr2];
                int right = triangle.get(itr1).get(itr2) + 
                            dp[itr1+1][itr2+1];
                dp[itr1][itr2] = Math.min(down,right);
            }
        }
        return dp[0][0];
    }

    private int minTotal(int row, int col, List<List<Integer>> triangle, Map<String,Integer> memo){
        if(row == triangle.size()-1){
            return triangle.get(row).get(col);
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int down = triangle.get(row).get(col) + minTotal(row+1, col, triangle, memo);
        int right = triangle.get(row).get(col) + minTotal(row+1, col+1,triangle, memo);
        memo.put(key,Math.min(down,right));
        return memo.get(key);
    }
}