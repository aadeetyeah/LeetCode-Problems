class Solution {
       public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int arr[]=new int[nums.length];
           
        for(int itr1=2;itr1<nums.length;itr1++){
            if(nums[itr1]-nums[itr1-1]==nums[itr1-1]-nums[itr1-2]){
                arr[itr1]=arr[itr1-1]+1;
            }
        }
        int count=0;
        for(int itr1=2;itr1<arr.length;itr1++){
            count+=arr[itr1];
        }
        return count;
        
    }

}