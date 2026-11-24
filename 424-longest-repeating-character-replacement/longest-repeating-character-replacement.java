class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen = 0, maxFreq = 0, left = 0, right = 0;

        Map<Character, Integer> memo = new HashMap<>();
        while(right < s.length()){
            memo.put(s.charAt(right),memo.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,memo.get(s.charAt(right)));
            if(right-left+1-maxFreq > k){
                memo.put(s.charAt(left),memo.get(s.charAt(left))-1);
                if(memo.get(s.charAt(left))==0){
                    memo.remove(s.charAt(left));
                }
                left++;
            }else{
                maxlen = Math.max(maxlen, right-left+1);
            }
            right++;
        }
        return maxlen;
    }
}