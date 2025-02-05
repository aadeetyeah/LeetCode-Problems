class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int prefix[] = new int[nums.size()+1];
        int min = Integer.MAX_VALUE;

        prefix[0] = 0;
        for(int itr1 = 0;itr1<nums.size();itr1++){
            prefix[itr1+1] = prefix[itr1] + nums.get(itr1);
        }

        for(int itr1=l; itr1<=r ; itr1++){

            for(int itr2 = 0; itr2+itr1 <= nums.size(); itr2++){
                int sum = prefix[itr2+itr1] - prefix[itr2];
                if(sum>0){
                    min = Math.min(min,sum);
                }
            }
        }

        return min == Integer.MAX_VALUE? -1 : min;
    }
}