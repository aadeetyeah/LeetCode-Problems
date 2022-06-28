class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer=new ArrayList<>();
        makeSubset(nums,0,new ArrayList<>(),answer);
        return answer;
    }
    
    private void makeSubset(int[] nums,int index,ArrayList<Integer> output,List<List<Integer>> answer){
        if(index>=nums.length){
            answer.add(new ArrayList<Integer>(output));
            return;
        }
        makeSubset(nums,index+1,new ArrayList<Integer>(output),answer);
        output.add(nums[index]);
        makeSubset(nums,index+1,output,answer);
        return;
    }
}