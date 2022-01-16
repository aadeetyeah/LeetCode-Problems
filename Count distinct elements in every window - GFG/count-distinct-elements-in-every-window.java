// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        ArrayList<Integer> l1=new ArrayList<Integer>();
        HashMap<Integer,Integer> hm1=new HashMap<>();
        int itr1=0,itr2=0,size=0;
        for( itr1=0;itr1<k;itr1++){
            hm1.put(A[itr1],hm1.getOrDefault(A[itr1],0)+1);    
        }
        l1.add(hm1.size());
        while(itr1<A.length){
            size=(itr1-itr2)+1;
            if(size>k){
                hm1.put(A[itr2],hm1.get(A[itr2])-1);
                if(hm1.get(A[itr2])==0){
                    hm1.remove(A[itr2]);
                }
                itr2++;
            }
            hm1.put(A[itr1],hm1.getOrDefault(A[itr1],0)+1);
            l1.add(hm1.size());
            itr1++;
        }
        return l1;
    }
}

