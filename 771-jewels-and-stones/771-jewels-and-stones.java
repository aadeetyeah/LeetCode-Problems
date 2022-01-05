class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        HashMap<Character,Integer> h1=new HashMap<>();
        
        
        for(int itr1=0;itr1<stones.length();itr1++){
            h1.put(stones.charAt(itr1),h1.getOrDefault(stones.charAt(itr1),0)+1);    
        }
        
        int count=0;
        for(int itr1=0;itr1<jewels.length();itr1++){
            count+=h1.getOrDefault(jewels.charAt(itr1),0);
        }
        return count;
    }
}