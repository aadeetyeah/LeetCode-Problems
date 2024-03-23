class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0,nums,ans,new ArrayList<Integer>());
        return ans;
    }
    
    private void subsets(int index, int[] nums,List<List<Integer>> ans,List<Integer> temp){
        ans.add(new ArrayList(temp));
        for(int itr1=index;itr1<nums.length;itr1++){
            if(itr1!=index && nums[itr1]==nums[itr1-1]){
                continue;
            }
            temp.add(nums[itr1]);
            subsets(itr1+1,nums,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}