class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxf = 0, maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(r < s.length()){
            if(!map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),1);
            }else{
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }

            maxf = Math.max(maxf,map.get(s.charAt(r)));

            if(r-l+1-maxf>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }else{
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}