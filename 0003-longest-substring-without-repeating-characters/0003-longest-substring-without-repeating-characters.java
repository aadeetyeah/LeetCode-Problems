class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int n = s.length();
        
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                if(left<=map.get(s.charAt(right))){
                    left = map.get(s.charAt(right))+1;
                }
            }
            map.put(s.charAt(right),right);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}