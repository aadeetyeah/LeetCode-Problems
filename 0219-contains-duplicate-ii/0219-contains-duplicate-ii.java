class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int itr1 = 0 ; itr1<nums.length; itr1++){
            
            if(map.containsKey(nums[itr1])){
                if(Math.abs(map.get(nums[itr1])-itr1)<=k){
                    return true;
                }
            }
            map.put(nums[itr1],itr1);
        }
        return false;
    }
}