// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int num=0;
        int max=0;
        int size=0;
        int ind=0;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        for(int itr1=0;itr1<arr.length;itr1++){
            num+=arr[itr1];
            if(hm.get(num)==null){
                hm.put(num,itr1);
            }else{
                ind=hm.get(num);
                size=itr1-ind;
                if(size>max){
                    max=size;
                }
            }
        }
        return max;
    }
}