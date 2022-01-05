class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> m1=new HashMap<>();
        int pairs=0;
        
        for(int itr1=0;itr1<nums.length;itr1++){
            m1.put(nums[itr1],m1.getOrDefault(nums[itr1],0)+1);
        }
        int temp=0;
        for(Map.Entry h1 : m1.entrySet()){
            temp=(int)h1.getValue();
            temp=(temp*(temp-1))/2;
            pairs+=temp;
        }
        return pairs;
    }
}