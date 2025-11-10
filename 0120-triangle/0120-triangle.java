class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String,Integer> memo = new HashMap<>();
        return minTotal(0,0,triangle,memo);
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