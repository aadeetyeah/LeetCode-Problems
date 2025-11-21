class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        
        int total = 0;
        for(int num : arr){
            total+=num;
        }
        Map<String,Integer> memo = new HashMap<>();
        if((total-diff)%2==1 || total-diff<0){
            return 0;
        }
        // return count(arr.length-1,(total-diff)/2,arr,memo);
        return countIterative(arr,(total-diff)/2);
    }
    
    private int countIterative(int nums[],int target){
        int dp[][] = new int[nums.length][target+1];
        
        if(nums[0]==0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }
        
        if(nums[0]!=0 && nums[0] <= target){
            dp[0][nums[0]] = 1;
        }
        for(int itr1 = 1;itr1<nums.length;itr1++){
            for(int itr2=0;itr2<target+1;itr2++){
                int dontpick = dp[itr1-1][itr2];
        
                int pickme = 0;
                if(nums[itr1] <= itr2){
                    pickme = dp[itr1-1][itr2-nums[itr1]];
                }
                dp[itr1][itr2] =dontpick + pickme;
            }
        }
        return dp[nums.length-1][target];
    }
    
    private int count(int index, int target, int[] nums,
    Map<String,Integer> memo){
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
