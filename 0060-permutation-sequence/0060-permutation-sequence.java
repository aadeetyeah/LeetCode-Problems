class Solution {
    public String getPermutation(int n, int k) {
        
        return getPermutations(n,k);
    }
    
    private String getPermutations(int n,int k){
        
        int fact = 1;
        List<Integer> nums = new ArrayList<Integer>();
        for(int itr1=1;itr1<n;itr1++){
            fact = fact * itr1;
            nums.add(itr1);
        }
        nums.add(n);
        k = k-1;
        String ans = "";
        int no = 0;
        while(true){
            no = nums.get(k/fact);
            ans = ans + Integer.toString(no);
            nums.remove(k/fact);
            if(nums.size()==0){
                break;
            }
            k = k % fact;
            fact = fact/nums.size();
        }
        return ans;
    }
}