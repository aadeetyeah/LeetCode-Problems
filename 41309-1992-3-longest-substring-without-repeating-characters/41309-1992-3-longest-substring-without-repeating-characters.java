class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                if(left <= map.get(s.charAt(right))){
                    left = map.get(s.charAt(right))+1;
                }
            }

            maxLen = Math.max(maxLen, right - left +1);
            map.put(s.charAt(right),right);
            right++;
        }   
        return maxLen;
    }
}