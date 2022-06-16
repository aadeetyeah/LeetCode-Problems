class Solution {
    public int fib(int n) {
        int arr[]=new int[n+1];
        return fibonacci(n,arr);
    }
    
    private int fibonacci(int n,int arr[]){
        if(n==1 || n==0){
            return n;
        }
        arr[n] =fibonacci(n-1,arr)+fibonacci(n-2,arr);
        return arr[n];
    }
}