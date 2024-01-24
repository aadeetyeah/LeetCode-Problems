class Solution {
    private long TEST = 1000000007;
    public int countGoodNumbers(long n) {
        if(n == 1){
            return 5;
        }
        long even = (n+1)/2;
        long prime = n/2;
        
        long evenRes = pow(even,5);
        long primeRes = pow(prime,4);
        return (int)((evenRes*primeRes)%TEST);
    }
    
    private long pow(long n,long x){
        if(n==1){
            return x;
        }
        long res = pow(n/2,x);
        if(n%2==0){
            return (res*res)%TEST;
        }else{
            return (x*res*res)%TEST;
        }
    }
}