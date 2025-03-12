class Solution {
    public int minFlips(String s) {
        int windowLen = s.length();
        s = s + s;

        System.out.println(s);
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for(int itr1 = 0; itr1 <s.length(); itr1++){
            alt1.append((itr1%2==0)? "0":"1");
            alt2.append((itr1%2==0)? "1":"0");
        }

        int left = 0;
        int diff1 = 0;
        int diff2 = 0;
        int minChanges = Integer.MAX_VALUE;


        for(int right = 0; right<s.length();right++){
            if(s.charAt(right)!=alt1.charAt(right)){
                diff1++;
            }
            if(s.charAt(right)!=alt2.charAt(right)){
                diff2++;
            }
            if(right-left+1 > windowLen){
                if(s.charAt(left)!=alt1.charAt(left)){
                    diff1--;
                }
                if(s.charAt(left)!=alt2.charAt(left)){
                    diff2--;
                }
                left++;           
            }
            if(right - left +1 == windowLen){
                minChanges = Math.min(Math.min(minChanges,diff1),diff2);
            }
        }
        return minChanges;
    }
}