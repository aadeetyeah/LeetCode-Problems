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
        return count(arr.length-1,(total-diff)/2,arr,memo);
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
