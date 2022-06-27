class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        return isSubseq(s,t,0,0,s.length(),t.length());
    }
    
    private boolean isSubseq(String s,String t,int sIndex,int tIndex,int sLen,int tLen){
        if(sIndex>=sLen){
            return true;
        }
        if(tIndex>=tLen){
            return false;
        }
        
        if(s.charAt(sIndex)==t.charAt(tIndex)){
            return isSubseq(s,t,sIndex+1,tIndex+1,sLen,tLen);
        }else{
            return isSubseq(s,t,sIndex,tIndex+1,sLen,tLen);
        }
    }
}