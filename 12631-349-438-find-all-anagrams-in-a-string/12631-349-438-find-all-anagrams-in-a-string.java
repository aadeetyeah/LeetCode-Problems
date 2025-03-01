class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] smap = new int[26];
        int[] pmap = new int[26];
        List<Integer> res = new ArrayList();
        if(s.length() < p.length() ) return res;
        for(int itr1 = 0; itr1 < p.length(); itr1++){
            pmap[p.charAt(itr1)-'a']++;
            smap[s.charAt(itr1)-'a']++;
        }

        if(Arrays.equals(pmap,smap)){
            res.add(0);
        }

        for(int itr1 = p.length();itr1 < s.length(); itr1++){
            smap[s.charAt(itr1)-'a']++;
            smap[s.charAt(itr1-p.length())-'a']--;
            if(Arrays.equals(pmap,smap)){
                res.add(itr1-p.length()+1);
            }   
        }
        return res;
    }
}