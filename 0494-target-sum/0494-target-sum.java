class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums){
            total+=num;
        }
        Map<String,Integer> memo = new HashMap<>();
        if((total-target)%2==1 || total-target<0){
            return 0;
        }
        return count(nums.length-1,(total-target)/2,nums,memo);
    
        // return countIterative(arr,(total-diff)/2);
    }

    private int count(int index, int target, int[] nums,
    Map<String,Integer> memo){
        System.out.print("\nind: "+index+ " target: "+target);
        if(index==0){
            if(target==0 && nums[0]==0) return 2;
            if(nums[0]==target || target==0) return 1;
            return 0;
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