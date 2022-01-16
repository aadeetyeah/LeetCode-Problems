// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> h1=new HashMap<>();
        long n1=0;
        h1.put(n1,1);
        long num=0;
        long count=0;
        for(int itr1=0;itr1<arr.length;itr1++){
            num+=arr[itr1];
            if(h1.containsKey(num)){
                count+=h1.get(num);
                h1.put(num,h1.get(num)+1);
            }else{
                h1.put(num,1);
            }
        }
        return count;
    }
}