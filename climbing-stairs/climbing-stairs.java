class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n];
        int start=0;
        return climb_stairs(start,n,arr);
    }
    public int climb_stairs(int start,int n,int arr[]){
        if(start>n){
            return 0;
        }
        if(start==n){
            return 1;
        }
        if(arr[start]!=0){
            return arr[start];
        }
        int oneStep=climb_stairs(start+1,n,arr);
        int twoStep=climb_stairs(start+2,n,arr);
        arr[start] =oneStep+twoStep;
        return arr[start];
    }
}