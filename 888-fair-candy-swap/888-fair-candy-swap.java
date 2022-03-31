/* Mathematical Problem */

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> s1=new HashSet<>();
        int sumA=0,sumB=0;
        for(int i : aliceSizes){
            sumA+=i;
            s1.add(i);
        }
        
        for(int j : bobSizes){
            sumB+=j;
        }
        
        int temp=(sumA-sumB)/2;
        
        int ans[]=new int[2];
        for(int j : bobSizes){
            if(s1.contains(temp+j)){
                ans[0]=temp+j;
                ans[1]=j;
            }
        }
        return ans;
    }
}