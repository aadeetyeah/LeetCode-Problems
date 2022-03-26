// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] nums, int n, int target) {
         int[] ans=new int[2];
        Arrays.fill(ans,-1);
        
        ans[0]=getFirstIndex(nums,target);
        if(ans[0]==-1){
            return 0;
        }
        ans[1]=getLastIndex(nums,target);
        return (ans[1]-ans[0])+1;
    }
    
    int getFirstIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        int mid;
        int answer=-1;
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]==target){
                answer=mid;
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
    
    int getLastIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        int mid;
        int answer=-1;
        
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                answer=mid;
                start=mid+1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
}