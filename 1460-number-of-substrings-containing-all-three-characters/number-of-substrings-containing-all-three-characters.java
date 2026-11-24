class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> memo = new HashMap<>();
        int count = 0;

        for(int itr1 = 0;itr1<s.length();itr1++){
            memo.put(s.charAt(itr1),itr1);
            if(memo.containsKey('a') && memo.containsKey('b') && memo.containsKey('c')){
                int ind = Math.min(memo.get('a'),Math.min(memo.get('b'),memo.get('c')));
                count+=ind+1;
            }
        }
        return count;
    }
}