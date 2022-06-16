class Solution {
    public int tribonacci(int n) {
        
        if(n==0){
            return 0;
        }
        int arr[]=new int[n+1];
        Arrays.fill(arr,-1);
        if(n>=3){
            arr[0]=0;
            arr[1]=1;
            arr[2]=1;
        }
        return tribo(n,arr);
    }
    
    private int tribo(int n,int arr[]){
        if(arr[n]!=-1){
            return arr[n];
        }
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        
        arr[n] = tribo(n-1,arr)+tribo(n-2,arr)+tribo(n-3,arr);
        return arr[n];
    }
}