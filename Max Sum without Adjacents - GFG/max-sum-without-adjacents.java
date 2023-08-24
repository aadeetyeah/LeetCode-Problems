//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        Map<Integer,Integer> memo = new HashMap<>();
        return maxNonAdjSum(arr,n-1,memo);
    }
    
    private int maxNonAdjSum(int arr[],int index,Map<Integer,Integer> memo){
        if(index==0){
            return arr[0];
        }
        
        if(index<0){
            return 0;
        }
        
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        
        int select = arr[index] + maxNonAdjSum(arr,index-2,memo);
        int noSelect = maxNonAdjSum(arr,index-1,memo);
        
        int res = Math.max(select, noSelect);
        memo.put(index,res);
        return res;
    }
}