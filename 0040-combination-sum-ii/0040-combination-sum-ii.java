class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        comboSum(0,candidates,target,result,new ArrayList<Integer>());
        return result;
        
    }
    private void comboSum(int index,int candidates[],int target, List<List<Integer>> result,
                         List<Integer> temp){
        
        if(target==0){
            result.add(new ArrayList(temp));
        }
            
        
        for(int itr1 = index;itr1<candidates.length;itr1++){
            if(itr1>index && candidates[itr1]==candidates[itr1-1]){
                continue;
            }
            if(target<candidates[index]){
                break;
            }
            temp.add(candidates[itr1]);
            comboSum(itr1+1,candidates,target-candidates[itr1],result,temp);
            temp.remove(temp.size()-1);
        }
        
        return;
    }
}