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
    int count(int[] arr, int n, int x) {
        // code here
        
        int first=firstPosition(arr,x);
        if(first==-1){
            return 0;
        }
        int last=lastPosition(arr,x);
        return (last-first)+1;
        
    }
    
    int firstPosition(int[] arr,int x){
        int start=0;
        int end=arr.length-1;
        
        int answer=-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==x){
                answer=mid;
                end=mid-1;
            }else if(arr[mid]<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
    
    int lastPosition(int[] arr,int x){
        int start=0;
        int end=arr.length-1;
        
        int answer=-1;
        int mid;
        
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==x){
                answer=mid;
                start=mid+1;
            }else if(arr[mid]<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
}