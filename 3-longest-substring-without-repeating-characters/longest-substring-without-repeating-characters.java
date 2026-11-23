class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> memo = new HashMap<>();
        int l = 0, r = 0;

        while(r < s.length()){
            if(memo.containsKey(s.charAt(r))){
                if(memo.get(s.charAt(r))>=l){
                    l = memo.get(s.charAt(r)) + 1;
                }
            }
            memo.put(s.charAt(r),r);
            int length = r-l+1;
            maxLen = Math.max(maxLen, length);
            r++;
        }
        return maxLen;
    }
}