class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[]=new int[2];
        
        int rItr=0;

        for(int itr1=0;itr1<nums.length-1;itr1++){
            result[rItr]=itr1;

            for(int itr2=itr1+1;itr2<nums.length;itr2++){
                if(nums[itr1]+nums[itr2]==target){
                    rItr++;
                    result[rItr]=itr2;
                    return result;
                }
            }
        }


        return result;
    }
}