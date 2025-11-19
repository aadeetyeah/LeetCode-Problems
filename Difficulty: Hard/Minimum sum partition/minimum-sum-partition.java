// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int total = 0;
        for(int num : arr){
            total+=num;
        }
        return subsetSumIterative(arr,total);
    }

    int subsetSumIterative(int arr[], int target){
        boolean[][] dp = new boolean[arr.length][(2*target)+1];
        for(int itr1=0; itr1<arr.length; itr1++){
            dp[itr1][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        
        for(int itr1= 1;itr1<arr.length;itr1++){
            for(int itr2=1;itr2<=target;itr2++){
                boolean take = false;
                if(arr[itr1]<=itr2){
                    take = dp[itr1-1][itr2-arr[itr1]];
                }
                boolean notTake = dp[itr1-1][itr2];
                
                dp[itr1][itr2] = take || notTake;
            }
        }
        int min = (int) 1e9;
        for(int itr1=0; itr1<target+1;itr1++){
            if(dp[arr.length-1][itr1]==true){
                min = Math.min(min,Math.abs(itr1-(target-itr1)));
            }
        }
        return min;
    }
}
