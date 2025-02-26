class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),1);
            }else{
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
            }

            maxFreq = Math.max(maxFreq,map.get(s.charAt(right)));

            if(right - left +1 - maxFreq > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }else{
                maxLen = Math.max(maxLen,right - left +1);
            }
            right++;
        }
        return maxLen;
    }
}