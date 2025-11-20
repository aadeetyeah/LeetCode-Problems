class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        Map<String,Integer> memo = new HashMap<>();
        return count(nums.length-1,target,nums,memo);
    }
    
    private int count(int index, int target, int[] nums,
    Map<String,Integer> memo){
        // if(target == 0){
        //     return 1;
        // }
        if(index == -1){
        if(target==0){
            return 1;
        }else{
            return 0;
        }
        }
        
        String  key = Integer.toString(index)+"_"
        +Integer.toString(target);
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int dontpick = count(index-1,target,nums,memo);
        
        int pickme = 0;
        if(nums[index] <= target){
            pickme = count(index-1, target-nums[index],nums,memo);
        }
        memo.put(key,dontpick + pickme);
        return memo.get(key);
    }
}