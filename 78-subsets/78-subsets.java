class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l1=new ArrayList<>();
        powerSet(0,nums,l1,new ArrayList<Integer>());
        return l1;
    }
    public void powerSet(int start,int nums[],List<List<Integer>> l1,List<Integer> currentList){
        if(start>=nums.length){
            l1.add(new ArrayList(currentList));
            return;
        }
        currentList.add(nums[start]);
        powerSet(start+1,nums,l1,currentList);
        currentList.remove(currentList.size()-1);
        powerSet(start+1,nums,l1,currentList);
    }
}