class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAllSubArraysTillK(nums,k) - countAllSubArraysTillK(nums,k-1);
    }

    private int countAllSubArraysTillK(int nums[], int k){
        int left = 0, right = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        if(k<0){
            return 0;
        }
        while(right < nums.length){
            if(!map.containsKey(nums[right])){
                map.put(nums[right],1);
            }else{
                map.put(nums[right],map.get(nums[right])+1);
            }

            while(map.size() > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count = count+ right-left +1;
            right++;
        }
        return count;
    }
}