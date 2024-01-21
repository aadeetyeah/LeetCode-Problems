class Solution {
    public int findTheWinner(int n, int k) {
        return findTheWinnerHelper(n,k);
    }
    
    private int findTheWinnerHelper(int n,int k){
        if(n == 1){
            return n;
        }
        int x = findTheWinnerHelper(n-1,k);
        int y = (x+k)%n;
        if(y == 0){
            return n;
        }
        return y;
    }
}