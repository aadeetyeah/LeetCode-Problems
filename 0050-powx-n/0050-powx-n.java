class Solution {
    public double myPow(double x, int n) {
        
        double res = power(x,Math.abs(n));
        res = n>=0?res:1/res;
        return res;
    }
    
    private double power(double x,int n){
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
        if(n%2==0){
            double res = power(x,n/2);    
            res = res * res;
            return res;
        }else{
            double res = power(x,n/2);
            res = res * res *x;
            return res;
        }
    }
    
}