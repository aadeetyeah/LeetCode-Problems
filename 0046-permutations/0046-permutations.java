class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> cache = new HashMap<>();
        permutate(0,nums,ans,new ArrayList<Integer>(),cache);
        
        return ans;
    }
    
    private void permutate(int index, int nums[],List<List<Integer>> ans,List<Integer> temp,Map<Integer,Integer> cache){
        
        if(temp.size()>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int itr1=0;itr1<nums.length;itr1++){
            if(cache.containsKey(nums[itr1])){
                continue;
            }
            cache.put(nums[itr1],1);
            temp.add(nums[itr1]);
            permutate(itr1+1,nums,ans,temp,cache);
            temp.remove(temp.size()-1);
            cache.remove(nums[itr1]);
        }
    }
}