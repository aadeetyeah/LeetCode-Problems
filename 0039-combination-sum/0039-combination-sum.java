class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        comboSum(0,candidates,target,result,new ArrayList<Integer>());
        return result;
    }
    
    private void comboSum(int index,int candidates[],int target, List<List<Integer>> result,
                         List<Integer> temp){
        if(index==candidates.length){
            if(target==0){
                result.add(new ArrayList(temp));
            }
            return;
        }
        if(target>=candidates[index]){
            temp.add(candidates[index]);
            comboSum(index,candidates,target-candidates[index],result,temp);
            temp.remove(temp.size()-1);
        }
        comboSum(index+1,candidates,target,result,temp);
        return;
    }
}